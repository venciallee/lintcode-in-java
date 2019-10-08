package com.bytetree.lintcode.string;

/**
 * 656. Multiply Strings
 * <p>
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2
 * <p>
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * <p>
 * Example
 * Example1
 * <p>
 * Input:
 * "123"
 * "45"
 * Output:
 * "5535"
 * Explanation:
 * 123 x 45 = 5535
 * Example2
 * <p>
 * Input:
 * "0"
 * "0"
 * Output:
 * "0"
 * <p>
 * <a href="https://www.lintcode.com/problem/multiply-strings/description">656. Multiply Strings</a>
 * <p>
 * Created by vencial on 2019-10-08.
 */
public class MultiplyStrings {

    /**
     * @param num1: a non-negative integers
     * @param num2: a non-negative integers
     * @return: return product of num1 and num2
     */
    public String multiply(String num1, String num2) {
        // write your code here
        int m = num1.length();
        int n = num2.length();
        String ans = "";
        int carry = 0;
        int[] resultArray = new int[m + n];
        int j;
        for (int i = m - 1; i >= 0; i--) {
            carry = 0;
            for (j = n - 1; j >= 0; j--) {
                int numsOf1 = num1.charAt(i) - '0';
                int numsOf2 = num2.charAt(j) - '0';
                int result = numsOf1 * numsOf2 + carry + resultArray[i + j + 1];
                resultArray[i + j + 1] = result % 10;
                carry = result / 10;
            }
            resultArray[i + j + 1] = carry;
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < (m + n - 1) && resultArray[i] == 0) {
            i++;
        }
        while (i < (m + n)) {
            sb.append(resultArray[i++]);
        }
        return sb.toString();
    }
}
