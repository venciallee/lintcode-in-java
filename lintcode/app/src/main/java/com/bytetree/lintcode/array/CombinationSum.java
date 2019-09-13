package com.bytetree.lintcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 135. Combination Sum
 * <p>
 * Given a set of candidtate numbers candidates and a target number target. Find all unique combinations in candidates where the numbers sums to target.
 * <p>
 * The same repeated number may be chosen from candidates unlimited number of times.
 * <p>
 * All numbers (including target) will be positive integers.
 * Numbers in a combination a1, a2, … , ak must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak)
 * Different combinations can be in any order.
 * The solution set must not contain duplicate combinations.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input: candidates = [2, 3, 6, 7], target = 7
 * Output: [[7], [2, 2, 3]]
 * Example 2:
 * <p>
 * Input: candidates = [1], target = 3
 * Output: [[1, 1, 1]]
 * <p>
 * <a href="https://www.lintcode.com/problem/combination-sum/description">135. Combination Sum</a>
 * <p>
 * Created by vencial on 2019-09-13.
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }

    private void backtrace(List<List<Integer>> list, List<Integer> tmp, int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        }
        else if (target == 0) {
            if (!list.contains(tmp)) {
                list.add(new ArrayList<>(tmp));
            }
        } else {
            for (int i = start; i < candidates.length; i++) {
                tmp.add(candidates[i]);
                backtrace(list, tmp, candidates, target - candidates[i], i);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
