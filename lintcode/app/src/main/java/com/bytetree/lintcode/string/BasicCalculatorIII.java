package com.bytetree.lintcode.string;

import java.util.Stack;

/**
 * 849. Basic Calculator III
 * <p>
 * mplement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * <p>
 * The expression string contains only non-negative integers, +, -, *, / operators , open ( and closing parentheses ) and empty spaces . The integer division should truncate toward zero.
 * <p>
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-2147483648, 2147483647]
 * <p>
 * Do not use the eval built-in library function.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input："1 + 1"
 * Output：2
 * Explanation：1 + 1 = 2
 * Example 2:
 * <p>
 * Input：" 6-4 / 2 "
 * Output：4
 * Explanation：4/2=2，6-2=4
 * <p>
 * <a href="https://www.lintcode.com/problem/basic-calculator-iii/description">849. Basic Calculator III</a>
 * <p>
 * Created by vencial on 2019-10-08.
 */
public class BasicCalculatorIII {

    /**
     * @param s: the expression string
     * @return: the answer
     */
    public int calculate(String s) {
        // Write your code here
        if (s == null  || s.length() == 0) return 0;
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }

            if (Character.isDigit(c)) {
                num = c - '0';
                while (i < s.length() - 1 && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10  + (s.charAt(i + 1) - '0');
                    i++;
                }
                nums.push(num);
                num = 0;
            } else if (c == '(')  {
                ops.push(c);
            } else if (c == ')') {
                while (ops.peek() != '(') {
                    nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!ops.isEmpty() && precedence(c, ops.peek()))  {
                    nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
                }
                ops.push(c);
            }
        }

        while (!ops.isEmpty()) {
            nums.push(operation(ops.pop(), nums.pop(), nums.pop()));
        }
        return nums.pop();
    }

    private int operation(char op, int b, int a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }

    private boolean precedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }

        return true;
    }
}
