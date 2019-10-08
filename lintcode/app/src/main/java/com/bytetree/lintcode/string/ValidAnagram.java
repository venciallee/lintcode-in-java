package com.bytetree.lintcode.string;

/**
 * 158. Valid Anagram
 * <p>
 * Write a method anagram(s,t) to decide if two strings are anagrams or not.
 * <p>
 * Have you met this question in a real interview?
 * Clarification
 * What is Anagram?
 * <p>
 * Two strings are anagram if they can be the same after change the order of characters.
 * Example
 * Example 1:
 * <p>
 * Input: s = "ab", t = "ab"
 * Output: true
 * Example 2:
 * <p>
 * Input:  s = "abcd", t = "dcba"
 * Output: true
 * Example 3:
 * <p>
 * Input:  s = "ac", t = "ab"
 * Output: false
 * Challenge
 * O(n) time, O(1) extra space
 * <p>
 * <a href="https://www.lintcode.com/problem/valid-anagram/description">158. Valid Anagram</a>
 * <p>
 * Created by vencial on 2019-10-08.
 */
public class ValidAnagram {

    /**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        int m = s.length();
        int n = t.length();
        int[] cntS = new int[256];
        int[] cntT = new int[256];
        for (int i = 0; i < m; i++) {
            cntS[s.charAt(i)]++;
        }

        for (int i = 0; i < n; i++) {
            cntT[t.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (cntS[i] != cntT[i]) return false;
        }

        return true;
    }
}
