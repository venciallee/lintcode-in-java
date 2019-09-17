package com.bytetree.lintcode.string;

/**
 * 640. One Edit Distance
 * <p>
 * Given two strings S and T, determine if they are both one edit distance apart.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input: s = "aDb", t = "adb"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "ab", t = "ab"
 * Output: false
 * Explanation:
 * s=t ,so they aren't one edit distance apart
 * <p>
 * <a href="https://www.lintcode.com/problem/one-edit-distance/description">640. One Edit Distance</a>
 * <p>
 * Created by vencial on 2019-09-16.
 */
public class OneEditDistance {

    /**
     * @param s: a string
     * @param t: a string
     * @return: true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        // write your code here
        int sLength = s.length();
        int tLength = t.length();
        if (Math.abs(sLength - tLength) > 2) return false;

        if (sLength > tLength) {
            return isOneEditDistance(t, s);
        }
        for (int i = 0; i < sLength; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (sLength == tLength) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                return s.substring(i).equals(t.substring(i + 1));
            }
        }
        return sLength != tLength;
    }
}
