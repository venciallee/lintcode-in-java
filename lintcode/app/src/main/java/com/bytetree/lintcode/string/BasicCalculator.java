package com.bytetree.lintcode.string;

import java.util.Stack;

/**
 * 978. Basic Calculator
 * <p>
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string may contain open '(' and closing parentheses ')', the plus '+' or minus sign '-', non-negative integers and empty spaces ' '.
 * <p>
 * You may assume that the given expression is always valid.
 * <p>
 * Example
 * Example 1
 * <p>
 * Input："1 + 1"
 * Output：2
 * Example 2
 * <p>
 * Input："(1+(4+5+2)-3)+(6+8)"
 * Output：23
 * <p>
 * <a href="https://www.lintcode.com/problem/basic-calculator/description">978. Basic Calculator</a>
 * <p>
 * Created by vencial on 2019-10-08.
 */
public class BasicCalculator {

    /**
     * @param s: the given expression
     * @return: the result of expression
     */
    public int calculate(String s) {
        // Write your code here
        Stack<Integer> stack = new Stack<>();

        int result = 0;
        int num = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * num;
                num = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }
        if (num != 0) {
            result += sign * num;
        }
        return result;
    }
}
