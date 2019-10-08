package com.bytetree.lintcode.dp;

/**
 * 108. Palindrome Partitioning II
 * <p>
 * Given a string s, cut s into some substrings such that every substring is a palindrome.
 * <p>
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input: "a"
 * Output: 0
 * Explanation: "a" is already a palindrome, no need to split.
 * Example 2:
 * <p>
 * Input: "aab"
 * Output: 1
 * Explanation: Split "aab" once, into "aa" and "b", both palindrome.
 * <p>
 * <a href="https://www.lintcode.com/problem/palindrome-partitioning-ii/description">108. Palindrome Partitioning II</a>
 * <p>
 * Created by vencial on 2019-10-07.
 */
public class PalindromePartitioningII {

    /**
     * @param s: A string
     * @return: An integer
     */
    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        // write your code here
        int length = s.length();
        int dp[] = new int[length + 1];
        for (int i = 0; i <= length; i++) {
            dp[i] = i - 1;
        }
        boolean [][] isPalindrome = getIsPalindrome(s);
        for (int i = 1; i <= length; i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[length];
    }


    private boolean[][] getIsPalindrome(String s) {
        int length = s.length();
        boolean[][] isPalindrome = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < length - 1; i++) {
            isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        for (int lengthOfPalindrome = 2; lengthOfPalindrome < length; lengthOfPalindrome++) {
            for (int i = 0; i + lengthOfPalindrome < length; i++) {
                isPalindrome[i][i + lengthOfPalindrome] = isPalindrome[i + 1][i + lengthOfPalindrome - 1] && s.charAt(i) == s.charAt(i + lengthOfPalindrome);
            }
        }
        return isPalindrome;
    }
}
