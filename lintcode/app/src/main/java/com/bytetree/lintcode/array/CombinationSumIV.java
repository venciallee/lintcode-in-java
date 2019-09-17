package com.bytetree.lintcode.array;

import java.util.Arrays;

/**
 * 564. Combination Sum IV
 * <p>
 * Given an integer array nums with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 * <p>
 * Example
 * Example1
 * <p>
 * Input: nums = [1, 2, 4], and target = 4
 * Output: 6
 * Explanation:
 * The possible combination ways are:
 * [1, 1, 1, 1]
 * [1, 1, 2]
 * [1, 2, 1]
 * [2, 1, 1]
 * [2, 2]
 * [4]
 * Example2
 * <p>
 * Input: nums = [1, 2], and target = 4
 * Output: 5
 * Explanation:
 * The possible combination ways are:
 * [1, 1, 1, 1]
 * [1, 1, 2]
 * [1, 2, 1]
 * [2, 1, 1]
 * [2, 2]
 * <p>
 * <a href="https://www.lintcode.com/problem/combination-sum-iv/description">564. Combination Sum IV</a>
 * <p>
 * Created by vencial on 2019-09-16.
 */
public class CombinationSumIV {

    /**
     * @param nums: an integer array and all positive numbers, no duplicates
     * @param target: An integer
     * @return: An integer
     */
    private int[] dp;
    public int backPackVI(int[] nums, int target) {
        // write your code here

        // if (target == 0) return 1;

        // int ans = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (target >= nums[i]) {
        //         ans += backPackVI(nums, target - nums[i]);
        //     }
        // }
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;

        return helper(nums, target);
    }

    private int helper(int[] nums, int target) {
        if (dp[target] != -1) return dp[target];

        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                ans += helper(nums, target - nums[i]);
            }
        }
        dp[target] = ans;
        return ans;
    }
}
