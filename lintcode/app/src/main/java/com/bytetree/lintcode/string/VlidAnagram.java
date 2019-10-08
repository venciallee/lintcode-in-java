package com.bytetree.lintcode.string;

/**
 * 773. Vlid Anagram
 * <p>
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * <p>
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "rat", t = "car"
 * Output: false
 * <p>
 * <a href="https://www.lintcode.com/problem/vlid-anagram/description">773. Vlid Anagram</a>
 * <p>
 * Created by vencial on 2019-10-08.
 */
public class VlidAnagram {

    /**
     * @param s: string s
     * @param t: string t
     * @return: Given two strings s and t, write a function to determine if t is an anagram of s.
     */
    public boolean isAnagram(String s, String t) {
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
