package com.bytetree.lintcode.string;

/**
 * 53. Reverse Words in a String
 * <p>
 * Given an input string, reverse the string word by word.
 * <p>
 * Clarification
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word and some words have punctuation at the end.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 * Example
 * Example 1:
 * Input:  "the sky is blue"
 * Output:  "blue is sky the"
 * <p>
 * Explanation:
 * return a reverse the string word by word.
 * <p>
 * Example 2:
 * Input:  "hello world"
 * Output:  "world hello"
 * <p>
 * Explanation:
 * return a reverse the string word by word.
 * <p>
 * <a href="https://www.lintcode.com/problem/reverse-words-in-a-string/description">53. Reverse Words in a String</a>
 * <p>
 * Created by vencial on 2019-09-11.
 */
public class ReverseWordsinaString {

    /*
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        // write your code here
        int length = s.length();
        int mid = length / 2;
        char[] words = s.toCharArray();
        reverse(words, 0, length - 1);

        int start = 0;
        for (int i = 0; i < length; i++) {
            if (words[i] == ' ') {
                reverse(words, start, i - 1);
                start = i + 1;
            }
        }

        reverse(words, start, length - 1);

        return cleanSpaces(words, length);

    }

    private void reverse(char[] words, int start, int end) {
        while (start < end) {
            char tmp = words[start];
            words[start] = words[end];
            words[end] = tmp;
            start++;
            end--;
        }
    }

    // trim leading, trailing and multiple spaces
    String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }
}
