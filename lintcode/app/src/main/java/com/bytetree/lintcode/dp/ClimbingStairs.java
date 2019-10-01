package com.bytetree.lintcode.dp;

/**
 * 111. Climbing Stairs
 * <p>
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Example
 * Example 1:
 * Input:  n = 3
 * Output: 3
 * <p>
 * Explanation:
 * 1) 1, 1, 1
 * 2) 1, 2
 * 3) 2, 1
 * total 3.
 * <p>
 * <p>
 * Example 2:
 * Input:  n = 1
 * Output: 1
 * <p>
 * Explanation:
 * only 1 way.
 * <p>
 * <a href="https://www.lintcode.com/problem/climbing-stairs/description">111. Climbing Stairs</a>
 * <p>
 * Created by vencial on 2019-09-30.
 */
public class ClimbingStairs {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n <= 2) return n;
        int dp[] = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }
}
