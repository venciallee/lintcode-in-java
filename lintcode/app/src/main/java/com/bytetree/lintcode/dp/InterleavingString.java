package com.bytetree.lintcode.dp;

/**
 * 29. Interleaving String
 * <p>
 * Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * Example 1:
 * <p>
 * Input:
 * "aabcc"
 * "dbbca"
 * "aadbbcbcac"
 * Output:
 * true
 * Example 2:
 * <p>
 * Input:
 * ""
 * ""
 * "1"
 * Output:
 * false
 * Example 3:
 * <p>
 * Input:
 * "aabcc"
 * "dbbca"
 * "aadbbbaccc"
 * Output:
 * false
 * Challenge
 * O(n2) time or better
 * <p>
 * <a href="https://www.lintcode.com/problem/interleaving-string/description">29. Interleaving String</a>
 * <p>
 * Created by vencial on 2019-11-26.
 */
public class InterleavingString {

    /**
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        int m = s1.length();
        int n = s2.length();
        if (m + n != s3.length()) return false;
        boolean dp[][] = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1))) || (dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1)));
            }
        }

        return dp[m][n];
    }
}
