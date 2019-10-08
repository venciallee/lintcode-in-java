package com.bytetree.lintcode.string;

import java.util.Stack;

/**
 * 980. Basic Calculator II
 * <p>
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * <p>
 * You may assume that the given expression is always valid.
 * <p>
 * Do not use the eval built-in library function.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input:
 * "3+2*2"
 * Output:
 * 7
 * Example 2:
 * <p>
 * Input:
 * " 3/2 "
 * Output:
 * 1
 * <p>
 * <a href="https://www.lintcode.com/problem/basic-calculator-ii/description">980. Basic Calculator II</a>
 * <p>
 * Created by vencial on 2019-10-08.
 */
public class BasicCalculatorII {
    /**
     * @param s: the given expression
     * @return: the result of expression
     */
    public int calculate(String s) {
        // Write your code here
        if (s == null || s.length() == 0) return 0;
        int length = s.length();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < length; i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }

            if (!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i) || i == length - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    int top = stack.pop();
                    stack.push(top * num);
                } else if (sign == '/') {
                    int top = stack.pop();
                    stack.push(top / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;

    }
}
