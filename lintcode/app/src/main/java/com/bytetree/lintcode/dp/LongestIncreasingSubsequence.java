package com.bytetree.lintcode.dp;

/**
 * 76. Longest Increasing Subsequence
 * <p>
 * Given a sequence of integers, find the longest increasing subsequence (LIS).
 * <p>
 * You code should return the length of the LIS.
 * <p>
 * Clarification
 * What's the definition of longest increasing subsequence?
 * <p>
 * The longest increasing subsequence problem is to find a subsequence of a given sequence in which the subsequence's elements are in sorted order, lowest to highest, and in which the subsequence is as long as possible. This subsequence is not necessarily contiguous, or unique.
 * <p>
 * https://en.wikipedia.org/wiki/Longest_increasing_subsequence
 * <p>
 * Example
 * Example 1:
 * Input:  [5,4,1,2,3]
 * Output:  3
 * <p>
 * Explanation:
 * LIS is [1,2,3]
 * <p>
 * <p>
 * Example 2:
 * Input: [4,2,4,5,3,7]
 * Output:  4
 * <p>
 * Explanation:
 * LIS is [2,4,5,7]
 * <p>
 * <a href="https://www.lintcode.com/problem/longest-increasing-subsequence/description">76. Longest Increasing Subsequence</a>
 * <p>
 * Created by vencial on 2019-10-03.
 */
public class LongestIncreasingSubsequence {

    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) return 0;
        int length = nums.length;
        int dp[] = new int[length];
        dp[0] = 1;
        int lis = 0;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            lis = Math.max(lis, dp[i]);
        }
        return lis;
    }
}
