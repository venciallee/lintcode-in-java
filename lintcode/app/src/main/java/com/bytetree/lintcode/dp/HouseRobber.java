package com.bytetree.lintcode.dp;

/**
 * 392. House Robber
 * <p>
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input: [3, 8, 4]
 * Output: 8
 * Explanation: Just rob the second house.
 * Example 2:
 * <p>
 * Input: [5, 2, 1, 3]
 * Output: 8
 * Explanation: Rob the first and the last house.
 * <p>
 * <a href="https://www.lintcode.com/problem/house-robber/description">392. House Robber</a>
 * <p>
 * Created by vencial on 2019-10-03.
 */
public class HouseRobber {
    /**
     * @param A: An array of non-negative integers
     * @return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return A[0];
        int length = A.length;
        long dp[] = new long[length + 1];
        dp[0] = A[0];
        dp[1] = A[1];
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + A[i]);
        }
        return dp[length - 1];
    }
}
