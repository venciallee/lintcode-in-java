package com.bytetree.lintcode.dp;

/**
 * 110. Minimum Path Sum
 * <p>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * You can only go right or down in the path..
 * <p>
 * Example
 * Example 1:
 * Input:  [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * <p>
 * Explanation:
 * Path is: 1 -> 3 -> 1 -> 1 -> 1
 * <p>
 * <p>
 * Example 2:
 * Input:  [[1,3,2]]
 * Output: 6
 * <p>
 * Explanation:
 * Path is: 1 -> 3 -> 2
 * <p>
 * <a href="https://www.lintcode.com/problem/minimum-path-sum/description">110. Minimum Path Sum</a>
 * <p>
 * Created by vencial on 2019-09-30.
 */
public class MinimumPathSum {

    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        // write your code here
        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m][n];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];

        }

        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int value = grid[i][j];
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j-1]) + value;
            }
        }

        return dp[m-1][n-1];
    }
}
