package com.bytetree.lintcode.stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 528. Flatten Nested List Iterator
 * <p>
 * Given a nested list of integers, implement an iterator to flatten it.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Example
 * Example1
 * <p>
 * Input: list = [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Example2
 * <p>
 * Input: list = [1,[4,[6]]]
 * Output: [1,4,6]
 * <p>
 * <a href="https://www.lintcode.com/problem/flatten-nested-list-iterator/description">528. Flatten Nested List Iterator</a>
 * <p>
 * Created by vencial on 2019-09-15.
 */
public class FlattenNestedListIterator  implements Iterator<Integer> {

    private Stack<NestedInteger> stack;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        stack = new Stack<>();
        pushAllInteger(nestedList);
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        if (!hasNext()) return null;

        return stack.pop().getInteger();
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        while (!stack.isEmpty()) {
            NestedInteger nInteger = stack.peek();
            if (nInteger.isInteger()) {
                return true;
            }
            stack.pop();
            pushAllInteger(nInteger.getList());
        }

        return false;
    }

    @Override
    public void remove() {
        stack.pop();
    }

    private void pushAllInteger(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

     // This is the interface that allows for creating nested lists.
     // You should not implement it, or speculate about its implementation
     public interface NestedInteger {

         // @return true if this NestedInteger holds a single integer,
         // rather than a nested list.
         public boolean isInteger();
         // @return the single integer that this NestedInteger holds,
         // if it holds a single integer
         // Return null if this NestedInteger holds a nested list
         public Integer getInteger();

         // @return the nested list that this NestedInteger holds,
         // if it holds a nested list
         // Return null if this NestedInteger holds a single integer
         public List<NestedInteger> getList();
     }
}
