package com.bytetree.lintcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 153. Combination Sum II
 * <p>
 * Given an array num and a number target. Find all unique combinations in num where the numbers sum to target.
 * <p>
 * Each number in num can only be used once in one combination.
 * All numbers (including target) will be positive integers.
 * Numbers in a combination a1, a2, … , ak must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak)
 * Different combinations can be in any order.
 * The solution set must not contain duplicate combinations.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input: num = [7,1,2,5,1,6,10], target = 8
 * Output: [[1,1,6],[1,2,5],[1,7],[2,6]]
 * Example 2:
 * <p>
 * Input: num = [1,1,1], target = 2
 * Output: [[1,1]]
 * Explanation: The solution set must not contain duplicate combinations.
 * <p>
 * <a href="https://www.lintcode.com/problem/combination-sum-ii/description">153. Combination Sum II</a>
 * <p>
 * Created by vencial on 2019-09-13.
 */
public class CombinationSumII {

    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(num);
        backtrack(list, new ArrayList(), num, target, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tmp, int[] num, int target, int start) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            if (!list.contains(tmp)) {
                list.add(new ArrayList<>(tmp));
            }
        } else {
            for (int i = start; i < num.length; i++) {
                if(i > start && num[i] == num[i-1]) continue; // skip duplicates
                tmp.add(num[i]);
                backtrack(list, tmp, num, target - num[i], i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

}
