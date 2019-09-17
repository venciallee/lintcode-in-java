package com.bytetree.lintcode.string;

/**
 * 213. String Compression
 * <p>
 * Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa would become a2b1c5a3.
 * <p>
 * If the "compressed" string would not become smaller than the original string, your method should return the original string.
 * <p>
 * You can assume the string has only upper and lower case letters (a-z).
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input: str = "aabcccccaaa"
 * Output: "a2b1c5a3"
 * Example 2:
 * <p>
 * Input: str = "aabbcc"
 * Output: "aabbcc"
 * <p>
 * <a href="https://www.lintcode.com/problem/string-compression/description">213. String Compression</a>
 * <p>
 * Created by vencial on 2019-09-15.
 */
public class StringCompression {

    /**
     * @param originalString: a string
     * @return: a compressed string
     */
    public String compress(String originalString) {
        // write your code here
        String compressString = dfs(originalString, 0, originalString.length());
        if (compressString.length() >= originalString.length()) {
            return originalString;
        }
        return compressString;
    }

    private String dfs(String originalString, int start, int end) {
        if (start >= end) return "";

        char repeatChar = originalString.charAt(start);
        int count = 0;
        String compressString = null;
        for (int i = start; i < end; i++) {
            if (repeatChar == originalString.charAt(i)) {
                count++;
            } else {
                compressString = repeatChar + "" + count + dfs(originalString, i, end);
                break;
            }
            if (i == end - 1) {
                compressString = repeatChar + "" + count;
            }
        }

        return compressString;
    }
}
