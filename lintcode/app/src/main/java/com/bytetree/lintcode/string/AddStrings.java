package com.bytetree.lintcode.string;

/**
 * 655. Add Strings
 * <p>
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input : num1 = "123", num2 = "45"
 * Output : "168"
 * <p>
 * <a href="https://www.lintcode.com/problem/add-strings/description">655. Add Strings</a>
 * <p>
 * Created by vencial on 2019-10-07.
 */
public class AddStrings {

    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
        // write your code here
        String ans = "";
        int i = num1.length();
        int j = num2.length();
        int carry = 0;
        while (i > 0 || j > 0) {
            int numOf1 = 0;
            if (i > 0) {
                numOf1 = num1.charAt(i - 1) - '0';
            }
            int numOf2 = 0;
            if (j > 0) {
                numOf2 = num2.charAt(j - 1) - '0';
            }
            int sum = numOf1 + numOf2 + carry;
            ans = (char)(sum % 10 + '0') + ans;
            carry = sum / 10;
            i--;
            j--;
        }

        return carry == 1 ? "1" + ans : ans;
    }
}
