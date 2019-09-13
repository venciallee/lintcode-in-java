package com.bytetree.lintcode.dp;

/**
 * 168. Burst Balloons
 * <p>
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * <p>
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * <p>
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input：[4, 1, 5, 10]
 * Output：270
 * Explanation：
 * nums = [4, 1, 5, 10] burst 1, get coins 4 * 1 * 5 = 20
 * nums = [4, 5, 10]   burst 5, get coins 4 * 5 * 10 = 200
 * nums = [4, 10]    burst 4, get coins 1 * 4 * 10 = 40
 * nums = [10]    burst 10, get coins 1 * 10 * 1 = 10
 * Total coins 20 + 200 + 40 + 10 = 270
 * Example 2:
 * <p>
 * Input：[3,1,5]
 * Output：35
 * Explanation：
 * nums = [3, 1, 5] burst 1, get coins 3 * 1 * 5 = 15
 * nums = [3, 5] burst 3, get coins 1 * 3 * 5 = 15
 * nums = [5] burst 5, get coins 1 * 5 * 1 = 5
 * Total coins 15 + 15 + 5  = 35
 * <p>
 * <a href="https://www.lintcode.com/problem/burst-balloons/description">168. Burst Balloons</a>
 * <p>
 * Created by vencial on 2019-09-13.
 */
public class BurstBalloons {

    /**
     * @param nums: A list of integer
     * @return: An integer, maximum coins
     */
    public int maxCoins(int[] nums) {
        // write your code here
        int length = nums.length;
        int dp[][] = new int[length][length];
        return maxCoins(nums, 0, length - 1, dp);
    }

    private int maxCoins(int[] nums, int start, int end, int[][] dp) {
        if (start > end) return 0;

        if (dp[start][end] != 0) return dp[start][end];
        int max = nums[start];
        for (int i = start; i <= end; i++) {
            int value = maxCoins(nums, start, i - 1, dp) + get(nums, start - 1) * get(nums, i) * get(nums, end + 1) + maxCoins(nums, i + 1, end, dp);
            max = Math.max(max, value);
        }

        dp[start][end] = max;
        return max;
    }

    private int get(int nums[], int i) {
        if (i == -1 || i == nums.length) return 1;

        return nums[i];
    }
}
