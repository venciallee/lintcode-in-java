package com.bytetree.lintcode.dp;

/**
 * 115. Unique Paths II
 * <p>
 * Follow up for "Unique Paths":
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * m and n will be at most 100.
 * <p>
 * Example
 * Example 1:
 * Input: [[0]]
 * Output: 1
 * <p>
 * <p>
 * Example 2:
 * Input:  [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * <p>
 * Explanation:
 * Only 2 different path.
 * <p>
 * <a href="https://www.lintcode.com/problem/unique-paths-ii/description">115. Unique Paths II</a>
 * <p>
 * Created by vencial on 2019-10-04.
 */
public class UniquePathsII {

    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid.length == 0 || obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != 1) {
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] != 1) {
                dp[0][i] = 1;
            } else {
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
