package com.bytetree.lintcode.dp;

/**
 * 118. Distinct Subsequences
 * <p>
 * Given two strings S and T. Count the number of distinct subsequences of S which equals T.
 * <p>
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not)
 * <p>
 * Have you met this question in a real interview?
 * Example
 * Example 1:
 * <p>
 * Input: S = "rabbbit", T = "rabbit"
 * Output: 3
 * Explanation: You could remove any 'b' in S, so there are 3 ways to get T.
 * Example 2:
 * <p>
 * Input: S = "abcd", T = ""
 * Output: 1
 * Explanation: There is only 1 way to get T - remove all chars in S.
 * Challenge
 * Do it in O(n^2n
 * ​2
 * ​​ ) time and O(n) memory.
 * <p>
 * O(n^2n
 * ​2
 * ​​ ) memory is also acceptable if you do not know how to optimize memory.
 * <p>
 * <a href="https://www.lintcode.com/problem/distinct-subsequences/description">118. Distinct Subsequences</a>
 * <p>
 * Created by vencial on 2019-11-26.
 */
public class DistinctSubsequences {

    /**
     * @param S: A string
     * @param T: A string
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        int m = S.length();
        int n = T.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (S.charAt(i) == T.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + dp[i][j+1];
                } else {
                    dp[i+1][j+1] = dp[i][j + 1];
                }
            }
        }

        return dp[m][n];
    }
}
