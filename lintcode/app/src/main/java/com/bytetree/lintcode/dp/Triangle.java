package com.bytetree.lintcode.dp;

/**
 * 109. Triangle
 * <p>
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input the following triangle:
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * Output: 11
 * Explanation: The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Example 2:
 * <p>
 * Input the following triangle:
 * [
 * [2],
 * [3,2],
 * [6,5,7],
 * [4,4,8,1]
 * ]
 * Output: 12
 * Explanation: The minimum path sum from top to bottom is 12 (i.e., 2 + 2 + 7 + 1 = 12).
 * <p>
 * <a href="https://www.lintcode.com/problem/triangle/description">109. Triangle</a>
 * <p>
 * Created by vencial on 2019-10-04.
 */
public class Triangle {

    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle == null || triangle.length == 0) return 0;
        int m = triangle.length;
        int n = triangle[0].length;
        int dp[][] = new int[m][m];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        int minimumPath = 0;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
            }
        }

        minimumPath = dp[m - 1][0];
        for (int i = 1; i < m; i++) {
            minimumPath = Math.min(minimumPath, dp[m - 1][i]);
        }

        return minimumPath;
    }
}
