package com.bytetree.lintcode.dp;

/**
 * 163. Unique Binary Search Trees
 * <p>
 * Given n, how many structurally unique BSTs (binary search trees) that store values 1...n?
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input:n = 3,
 * Output: 5
 * Explanation:there are a total of 5 unique BST's.
 * 1           3    3       2      1
 *  \         /    /       / \      \
 *   3      2     1       1   3      2
 *  /      /       \                  \
 * 2     1          2                  3
 * <p>
 * <a href="https://www.lintcode.com/problem/unique-binary-search-trees/description">163. Unique Binary Search Trees</a>
 * <p>
 * Created by vencial on 2019-09-13.
 */
public class UniqueBinarySearchTrees {

    /**
     * @param n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
        if (n == 0 || n == 1) return 1;
        // write your code here
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
