package com.bytetree.lintcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 17. Subsets
 * <p>
 * Given a set of distinct integers, return all possible subsets.
 * <p>
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input: [0]
 * Output:
 * [
 * [],
 * [0]
 * ]
 * Example 2:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * <p>
 * <a href="https://www.lintcode.com/problem/subsets/description">17. Subsets</a>
 * <p>
 * Created by vencial on 2019-10-10.
 */
public class Subsets {

    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);
        backtrace(nums, 0, ans, tmp);
        return ans;
    }

    private void backtrace(int[] nums, int start, List<List<Integer>> ans, List<Integer> tmp) {
        ans.add(new ArrayList<>(tmp));

        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtrace(nums, i + 1, ans, tmp);
            System.out.println(tmp.get(tmp.size() - 1));
            tmp.remove(tmp.size() - 1);
        }
    }
}
