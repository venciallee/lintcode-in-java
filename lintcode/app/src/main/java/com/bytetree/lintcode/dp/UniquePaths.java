package com.bytetree.lintcode.dp;

/**
 * 114. Unique Paths
 * <p>
 * A robot is located at the top-left corner of a m x n grid.
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid.
 * <p>
 * How many possible unique paths are there?
 * <p>
 * m and n will be at most 100.
 * The answer is guaranteed to be in the range of 32-bit integers
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input: n = 1, m = 3
 * Output: 1
 * Explanation: Only one path to target position.
 * Example 2:
 * <p>
 * Input:  n = 3, m = 3
 * Output: 6
 * Explanation:
 * D : Down
 * R : Right
 * 1) DDRR
 * 2) DRDR
 * 3) DRRD
 * 4) RRDD
 * 5) RDRD
 * 6) RDDR
 * <p>
 * <a href="https://www.lintcode.com/problem/unique-paths/description"></a>
 * <p>
 * Created by vencial on 2019-10-04.
 */
public class UniquePaths {

    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        if (m == 0 || n == 0) return 0;
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
