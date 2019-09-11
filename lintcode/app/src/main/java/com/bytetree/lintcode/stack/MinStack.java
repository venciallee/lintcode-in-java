package com.bytetree.lintcode.stack;

/**
 * 12. Min Stack
 * <p>
 * Implement a stack with following functions:
 * <p>
 * push(val) push val into the stack
 * pop() pop the top element and return it
 * min() return the smallest number in the stack
 * All above should be in O(1) cost.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input:
 * push(1)
 * pop()
 * push(2)
 * push(3)
 * min()
 * push(1)
 * min()
 * Output:
 * 1
 * 2
 * 1
 * Example 2:
 * <p>
 * Input:
 * push(1)
 * min()
 * push(2)
 * min()
 * push(3)
 * min()
 * Output:
 * 1
 * 1
 * 1
 * <p>
 * <a href="https://www.lintcode.com/problem/min-stack/description">12. Min Stack</a>
 * <p>
 * Created by vencial on 2019-09-11.
 */
public class MinStack {

    private Node head;
    private int count;
    public MinStack() {
        // do intialization if necessary
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        if (head == null) {
            head = new Node(number);
            count++;
        } else {
            Node node = new Node(number);
            node.next = head;
            head = node;
            count++;
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if (head != null) {
            Node node = head;
            head = head.next;
            count--;
            return node.value;
        }

        return -1;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        int min = Integer.MAX_VALUE;
        Node node = head;
        while(node != null) {
            min = Math.min(node.value, min);
            node = node.next;
        }
        return min;

    }

    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
        }
    }
}
