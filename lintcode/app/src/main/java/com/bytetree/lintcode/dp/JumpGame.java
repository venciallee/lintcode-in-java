package com.bytetree.lintcode.dp;

/**
 * 116. Jump Game
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * This problem have two method which is Greedy and Dynamic Programming.
 * <p>
 * The time complexity of Greedy method is O(n).
 * <p>
 * The time complexity of Dynamic Programming method is O(n^2).
 * <p>
 * We manually set the small data set to allow you pass the test in both ways. This is just to let you learn how to use this problem in dynamic programming ways. If you finish it in dynamic programming ways, you can try greedy method to make it accept again.
 * <p>
 * Example
 * Example 1
 * <p>
 * Input : [2,3,1,1,4]
 * Output : true
 * Example 2
 * <p>
 * Input : [3,2,1,0,4]
 * Output : false
 * <p>
 * <a href="https://www.lintcode.com/problem/jump-game/description">116. Jump Game</a>
 * <p>
 * Created by vencial on 2019-09-30.
 */
public class JumpGame {

    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        // write your code here
        int length = A.length;
        boolean dp[] = new boolean[length];
        dp[0] = true;
        for (int i = 1; i < length; i++) {
            dp[i] = false;
            for (int j = 0; j < i; j++) {
                if (dp[j] && A[j] >= i - j) {
                    dp[i] = true;
                }
            }
        }

        return dp[length - 1];
    }
}
