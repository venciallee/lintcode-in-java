package com.bytetree.lintcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * 651. Binary Tree Vertical Order Traversal
 * <p>
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * <p>
 * If two nodes are in the same row and column, the order should be from left to right.
 * <p>
 * Example
 * Example1
 * <p>
 * Inpurt:  {3,9,20,#,#,15,7}
 * Output: [[9],[3,15],[20],[7]]
 * Explanation:
 *    3
 *   /\
 *  /  \
 *  9  20
 *     /\
 *    /  \
 *   15   7
 * Example2
 * <p>
 * Input: {3,9,8,4,0,1,7}
 * Output: [[4],[9],[3,0,1],[8],[7]]
 * Explanation:
 *      3
 *     /\
 *    /  \
 *    9   8
 *   /\  /\
 *  /  \/  \
 *  4  01   7
 * <p>
 * <a href="https://www.lintcode.com/problem/binary-tree-vertical-order-traversal/description">651. Binary Tree Vertical Order Traversal</a>
 * <p>
 * Created by vencial on 2019-09-16.
 */
public class BinaryTreeVerticalOrderTraversal {

    /**
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // write your code here
        if (root == null) return new ArrayList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> qCol = new LinkedList<>();
        queue.offer(root);
        qCol.offer(0);

        List<List<Integer>> list = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int col = qCol.poll();
            if (map.containsKey(col)) {
                map.get(col).add(node.val);
            } else {
                List<Integer> itemList = new ArrayList<>();
                itemList.add(node.val);
                map.put(col, itemList);
            }
            if (node.left != null) {
                queue.offer(node.left);
                qCol.offer(col - 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                qCol.offer(col + 1);
            }
        }
        for (int key : map.keySet()) {
            list.add(map.get(key));
        }

        return list;
    }
}
