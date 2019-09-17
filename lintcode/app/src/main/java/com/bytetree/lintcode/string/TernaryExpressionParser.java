package com.bytetree.lintcode.string;

import java.util.Stack;

/**
 * 887. Ternary Expression Parser
 * <p>
 * Given a string representing arbitrarily nested ternary expressions, calculate the result of the expression. You can always assume that the given expression is valid and only consists of digits 0-9, ?, :, T and F (T and F represent True and False respectively).
 * <p>
 * The length of the given string is ≤ 10000.
 * Each number will contain only one digit.
 * The conditional expressions group right-to-left (as usual in most languages).
 * The condition will always be either T or F. That is, the condition will never be a digit.
 * The result of the expression will always evaluate to either a digit 0-9, T or F.
 * Example
 * Example 1:
 * Input: "F?1:T?3:1"
 * Output:  3
 * <p>
 * Explanation:
 * Result of the first expression is "False", so the answer of this expression is: T?3:1.
 * It is "True", so the answer is 3.
 * <p>
 * Example 2:
 * Input: "T?2:3"
 * Output:  2
 * <p>
 * Example 3:
 * Input: "T?T?F:5:3"
 * Output:  F
 * <p>
 * Explanation:
 * Just can be divided to : T? (T?F:5) : 3
 * So the answer is 'F'。
 * <p>
 * <a href="https://www.lintcode.com/problem/ternary-expression-parser/description">887. Ternary Expression Parser</a>
 * <p>
 * Created by vencial on 2019-09-16.
 */
public class TernaryExpressionParser {

    /**
     * @param expression: a string, denote the ternary expression
     * @return: a string
     */
    public String parseTernary(String expression) {
        // write your code here
        if (expression == null || expression.length() == 0) return expression;
        char wordArray[] = expression.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = wordArray.length - 1; i >= 0; i--) {
            char item = wordArray[i];
            if (!stack.isEmpty() && stack.peek() == '?') {
                // pop ?
                stack.pop();

                char firstChar = stack.pop();
                // pop :
                stack.pop();

                char secondChar = stack.pop();
                stack.push(item == 'T' ? firstChar : secondChar);

            } else {
                stack.push(item);
            }
        }
        return String.valueOf(stack.pop());
    }
}
