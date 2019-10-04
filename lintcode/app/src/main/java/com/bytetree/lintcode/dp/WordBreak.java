package com.bytetree.lintcode.dp;

import java.util.Set;

/**
 * 107. Word Break
 * <p>
 * Given a string s and a dictionary of words dict, determine if s can be break into a space-separated sequence of one or more dictionary words.
 * <p>
 * Example
 * Example 1:
 * Input:  "lintcode", ["lint", "code"]
 * Output:  true
 * <p>
 * Example 2:
 * Input: "a", ["a"]
 * Output:  true
 * <p>
 * <a href="https://www.lintcode.com/problem/word-break/description">107. Word Break</a>
 * <p>
 * Created by vencial on 2019-10-04.
 */
public class WordBreak {

    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here

        int length = s.length();

        boolean dp[] = new boolean[length + 1];

        dp[0] = true;
        int maxLength = getMaxLength(dict);
        for (int i = 1; i <= length; i++) {
            dp[i] = false;
            for (int j = 0; j <= i && j <= maxLength; j++) {
                if (!dp[i - j]) {
                    continue;
                }
                String word = s.substring(i - j, i);
                if (dict.contains(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }

    private int getMaxLength (Set<String> dict) {
        int maxLength = 0;
        for (String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }
}
