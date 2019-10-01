package com.bytetree.lintcode.dp;

/**
 * 117. Jump Game II
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * Example
 * Example 1
 * <p>
 * Input : [2,3,1,1,4]
 * Output : 2
 * Explanation : The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * <p>
 * <a href="https://www.lintcode.com/problem/jump-game-ii/description">117. Jump Game II</a>
 * <p>
 * Created by vencial on 2019-10-01.
 */
public class JumpGameII {
    /**
     * @param A: A list of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        int length = A.length;
        int dp[] = new int[length];
        dp[0] = 0;
        for (int i = 1; i < length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (A[j] >= i - j && dp[j] + 1 < dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        return dp[length - 1];
    }
}
