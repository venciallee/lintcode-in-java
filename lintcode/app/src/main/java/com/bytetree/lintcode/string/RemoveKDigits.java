package com.bytetree.lintcode.string;

import java.util.Stack;

/**
 * 1255. Remove K Digits
 * <p>
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 * <p>
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 * <p>
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 * <p>
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * <p>
 * <a href="https://www.lintcode.com/problem/remove-k-digits/description">1255. Remove K Digits</a>
 * <p>
 * Created by vencial on 2019-09-16.
 */
public class RemoveKDigits {

    /**
     * @param num: a string
     * @param k: an integer
     * @return: return a string
     */
    public String removeKdigits(String num, int k) {
        // write your code here
        int len = num.length();
        if (k == len) return "0";
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < len) {
            char item = num.charAt(i);
            while (k > 0 && !stack.isEmpty() && stack.peek() > item) {
                stack.pop();
                k--;
            }
            stack.push(item);
            i++;
        }

        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
