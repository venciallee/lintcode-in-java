package com.bytetree.lintcode.string;

import java.util.HashMap;

/**
 * 32. Minimum Window Substring
 * <p>
 * Given two strings source and target. Return the minimum substring of source which contains each char of target.
 * <p>
 * If there is no answer, return "".
 * You are guaranteed that the answer is unique.
 * target may contain duplicate char, while the answer need to contain at least the same number of that char.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input: source = "abc", target = "ac"
 * Output: "abc"
 * Example 2:
 * <p>
 * Input: source = "adobecodebanc", target = "abc"
 * Output: "banc"
 * Explanation: "banc" is the minimum substring of source string which contains each char of target "abc".
 * Example 3:
 * <p>
 * Input: source = "abc", target = "aa"
 * Output: ""
 * Explanation: No substring contains two 'a'.
 * Challenge
 * O(n) time
 * <p>
 * <a href="https://www.lintcode.com/problem/minimum-window-substring/description">32. Minimum Window Substring</a>
 * <p>
 * Created by vencial on 2019-09-11.
 */
public class MinimumWindowSubstring {

    /**
     * @param source : A string
     * @param target: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public String minWindow(String source , String target) {
        // write your code here

        String minSubString = null;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < target.length(); i++) {
            char subItem = target.charAt(i);
            if(map.containsKey(subItem)) {
                map.put(subItem, map.get(subItem) + 1);
            } else {
                map.put(subItem, 1);
            }
        }

        int left = 0;
        // the count of substring left to right contains target's char
        int count = 0;
        int minLeft = left;
        int minLen = source.length() + 1;
        for(int right = 0; right < source.length(); right++) {
            char item = source.charAt(right);
            if (map.containsKey(item)) {
                map.put(item, map.get(item) - 1);
                if (map.get(item) >= 0) {
                    count++;
                }

                // move left
                while (count == target.length()) {
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    char leftItem = source.charAt(left);
                    if (map.containsKey(source.charAt(left))) {
                        map.put(leftItem, map.get(leftItem) + 1);
                        if (map.get(leftItem) > 0) {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }

        if (minLen > source.length()) {
            return "";
        }

        return source.substring(minLeft, minLeft + minLen);
    }
}
