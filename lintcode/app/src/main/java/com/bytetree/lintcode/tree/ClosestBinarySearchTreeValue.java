package com.bytetree.lintcode.tree;

import java.util.Stack;

/**
 * 900. Closest Binary Search Tree Value
 * <p>
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * <p>
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 * <p>
 * Example
 * Example1
 * <p>
 * Input: root = {5,4,9,2,#,8,10} and target = 6.124780
 * Output: 5
 * Explanation：
 * Binary tree {5,4,9,2,#,8,10},  denote the following structure:
 *         5
 *        / \
 *      4    9
 *     /    / \
 *    2    8  10
 * Example2
 * <p>
 * Input: root = {3,2,4,1} and target = 4.142857
 * Output: 4
 * Explanation：
 * Binary tree {3,2,4,1},  denote the following structure:
 *      3
 *     / \
 *   2    4
 *  /
 * 1
 * <p>
 * <a href="https://www.lintcode.com/problem/closest-binary-search-tree-value/description">900. Closest Binary Search Tree Value</a>
 * <p>
 * Created by vencial on 2019-09-16.
 */
public class ClosestBinarySearchTreeValue {

    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        // write your code here
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int minTarget = Integer.MAX_VALUE;
        double minDiff = Double.MAX_VALUE;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            double diff = Math.abs(node.val - target);
            if (diff < minDiff) {
                minDiff = diff;
                minTarget = node.val;
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return minTarget;
    }
}
