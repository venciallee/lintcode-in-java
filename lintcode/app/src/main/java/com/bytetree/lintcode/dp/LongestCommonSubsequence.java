package com.bytetree.lintcode.dp;

/**
 * 77. Longest Common Subsequence
 * <p>
 * Given two strings, find the longest common subsequence (LCS).
 * <p>
 * Your code should return the length of LCS.
 * <p>
 * Clarification
 * What's the definition of Longest Common Subsequence?
 * <p>
 * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 * http://baike.baidu.com/view/2020307.htm
 * Example
 * Example 1:
 * Input:  "ABCD" and "EDCA"
 * Output:  1
 * <p>
 * Explanation:
 * LCS is 'A' or  'D' or 'C'
 * <p>
 * <p>
 * Example 2:
 * Input: "ABCD" and "EACB"
 * Output:  2
 * <p>
 * Explanation:
 * LCS is "AC"
 * <p>
 * <a href="https://www.lintcode.com/problem/longest-common-subsequence/description">77. Longest Common Subsequence</a>
 * <p>
 * Created by vencial on 2019-10-07.
 */
public class LongestCommonSubsequence {

    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int m = A.length();
        int n = B.length();
        int[][] dp = new int [m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
