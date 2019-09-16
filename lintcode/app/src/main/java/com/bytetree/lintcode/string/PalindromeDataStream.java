package com.bytetree.lintcode.string;

/**
 * 958. Palindrome Data Stream
 * <p>
 * There is a data stream, one letter at a time, and determine whether the current stream's arrangement can form a palindrome.
 * <p>
 * 1 <= |s| <= 10^5
 * <p>
 * Example
 * Example 1:
 * <p>
 * input:s = ['a','a','a','a','a']
 * outut:[1,1,1,1,1]
 * Explanation:
 * “a” can form a palindrome
 * “aa” can form a palindrome
 * “aaa” can form a palindrome
 * “aaaa” can form a palindrome
 * “aaaaa” can form a palindrome
 * Example 2:
 * <p>
 * input:s = ['a','b','a']
 * outut:[1,0,1]
 * Explanation:
 * “a” can form a palindrome
 * “ab” can't form a palindrome
 * “aba” can form a palindrome
 * <p>
 * <a href="https://www.lintcode.com/problem/palindrome-data-stream/description">958. Palindrome Data Stream</a>
 * <p>
 * Created by vencial on 2019-09-16.
 */
public class PalindromeDataStream {

    /**
     * @param s: The data stream
     * @return: Return the judgement stream
     */
    public int[] getStream(String s) {
        // Write your code here
        int length = s.length();
        int ans[] = new int[length];
        int letter[] = new int[26];
        int cnt = 0;
        for (int i = 0; i < length; i++) {
            char item = s.charAt(i);
            if (letter[item - 'a'] % 2 == 1) {
                cnt--;
                letter[item - 'a']++;
            } else {
                cnt++;
                letter[item - 'a']++;
            }
            if (cnt > 1) {
                ans[i] = 0;
            } else {
                ans[i] = 1;
            }
        }
        return ans;

    }
}
