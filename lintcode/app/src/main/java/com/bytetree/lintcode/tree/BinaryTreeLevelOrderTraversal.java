package com.bytetree.lintcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 69. Binary Tree Level Order Traversal
 * <p>
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * The first data is the root node, followed by the value of the left and right son nodes, and "#" indicates that there is no child node.
 * The number of nodes does not exceed 20.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Input：{1,2,3}
 * Output：[[1],[2,3]]
 * Explanation：
 * 1
 * / \
 * 2   3
 * it will be serialized {1,2,3}
 * level order traversal
 * Example 2:
 * <p>
 * Input：{1,#,2,3}
 * Output：[[1],[2],[3]]
 * Explanation：
 * 1
 * \
 * 2
 * /
 * 3
 * it will be serialized {1,#,2,3}
 * level order traversal
 * <p>
 * <a href="https://www.lintcode.com/problem/binary-tree-level-order-traversal/description">69. Binary Tree Level Order Traversal</a>
 * <p>
 * Created by vencial on 2019-10-08.
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
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
            list.add(levelList);
        }

        return list;
    }
}
