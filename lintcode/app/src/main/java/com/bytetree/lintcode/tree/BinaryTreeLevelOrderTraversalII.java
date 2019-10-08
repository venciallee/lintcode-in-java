package com.bytetree.lintcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 70. Binary Tree Level Order Traversal II
 * <p>
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input:
 * {1,2,3}
 * Output:
 * [[2,3],[1]]
 * Explanation:
 * 1
 * / \
 * 2   3
 * it will be serialized {1,2,3}
 * level order traversal
 * Example 2:
 * <p>
 * Input:
 * {3,9,20,#,#,15,7}
 * Output:
 * [[15,7],[9,20],[3]]
 * Explanation:
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * it will be serialized {3,9,20,#,#,15,7}
 * level order traversal
 * <p>
 * <a href="https://www.lintcode.com/problem/binary-tree-level-order-traversal-ii/description">70. Binary Tree Level Order Traversal II</a>
 * <p>
 * Created by vencial on 2019-10-08.
 */
public class BinaryTreeLevelOrderTraversalII {

    /**
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here

        if (root == null) return new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            list.add(0, levelList);
        }

        return list;
    }
}
