package com.bytetree.lintcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 136. Palindrome Partitioning
 * <p>
 * Given a string s. Partition s such that every substring in the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * Different partitionings can be in any order.
 * Each substring must be a continuous segment of s.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input: "a"
 * Output: [["a"]]
 * Explanation: Only 1 char in the string, only 1 way to split it (itself).
 * Example 2:
 * <p>
 * Input: "aab"
 * Output: [["aa", "b"], ["a", "a", "b"]]
 * Explanation: There are 2 ways to split "aab".
 * 1. Split "aab" into "aa" and "b", both palindrome.
 * 2. Split "aab" into "a", "a", and "b", all palindrome.
 * <p>
 * <a href="https://www.lintcode.com/problem/palindrome-partitioning/description">136. Palindrome Partitioning</a>
 * <p>
 * Created by vencial on 2019-10-10.
 */
public class PalindromePartitioning {

    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> ans = new ArrayList<>();
        backtrace(s, ans, new ArrayList<String>(), 0);
        return ans;
    }

    private void backtrace(String s, List<List<String>> ans, List<String> tmp, int start) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(tmp));
        } else {
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    tmp.add(s.substring(start, i + 1));
                    backtrace(s, ans, tmp, i + 1);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
