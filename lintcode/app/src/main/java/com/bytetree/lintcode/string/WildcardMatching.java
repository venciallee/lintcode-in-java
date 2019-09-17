package com.bytetree.lintcode.string;

/**
 * 192. Wildcard Matching
 * <p>
 * Implement wildcard pattern matching with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * <p>
 * Example
 * Example 1
 * <p>
 * Input:
 * "aa"
 * "a"
 * Output: false
 * Example 2
 * <p>
 * Input:
 * "aa"
 * "aa"
 * Output: true
 * Example 3
 * <p>
 * Input:
 * "aaa"
 * "aa"
 * Output: false
 * Example 4
 * <p>
 * Input:
 * "aa"
 * "*"
 * Output: true
 * Explanation: '*' can replace any string
 * Example 5
 * <p>
 * Input:
 * "aa"
 * "a*"
 * Output: true
 * Example 6
 * <p>
 * Input:
 * "ab"
 * "?*"
 * Output: true
 * Explanation: '?' -> 'a' '*' -> 'b'
 * Example 7
 * <p>
 * Input:
 * "aab"
 * "c*a*b"
 * Output: false
 * <p>
 * <a href="https://www.lintcode.com/problem/wildcard-matching/description">192. Wildcard Matching</a>
 * <p>
 * Created by vencial on 2019-09-15.
 */
public class WildcardMatching {

    /**
     * @param s: A string
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();
        int sLength = s.length();
        int pLength = p.length();
        boolean dp[][] = new boolean[sLength + 1][pLength + 1];
        dp[0][0] = true;
        for(int i = 1; i <= pLength; i++) {
            if (pCharArray[i - 1] == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i <= sLength; i++) {
            for (int j = 1; j <= pLength; j++) {
                if (pCharArray[j - 1] != '*') {
                    if (dp[i - 1][j - 1] && (pCharArray[j - 1] == '?' || sCharArray[i - 1] == pCharArray[j - 1])) {
                        dp[i][j] = true;
                    }
                } else {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[sLength][pLength];
    }
}
