package com.bytetree.lintcode.tree;

/**
 * 95. Validate Binary Search Tree
 * <p>
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * A single node tree is a BST
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input:  {-1}
 * Output：true
 * Explanation：
 * For the following binary tree（only one node）:
 * -1
 * This is a binary search tree.
 * Example 2:
 * <p>
 * Input:  {2,1,4,#,#,3,5}
 * Output: true
 * For the following binary tree:
 * 2
 * / \
 * 1   4
 * / \
 * 3   5
 * This is a binary search tree.
 * <p>
 * <a href="https://www.lintcode.com/problem/validate-binary-search-tree/description">95. Validate Binary Search Tree</a>
 * <p>
 * Created by vencial on 2019-10-10.
 */
public class ValidateBinarySearchTree {

    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return isValidHelper(root, null, null);
    }

    private boolean isValidHelper(TreeNode root, Integer lower, Integer upper) {
        if (root == null) return true;

        if (lower != null && lower >= root.val || upper != null && upper <= root.val) return false;

        if (!isValidHelper(root.left, lower, root.val)) return false;
        if (!isValidHelper(root.right, root.val, upper)) return false;

        return true;
    }
}
