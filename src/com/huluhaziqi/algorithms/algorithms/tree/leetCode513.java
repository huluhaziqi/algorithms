package com.huluhaziqi.algorithms.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class leetCode513 {
    /**
     * 513. Find Bottom Left Tree Value
     * Medium
     *
     * 735
     *
     * 122
     *
     * Add to List
     *
     * Share
     * Given a binary tree, find the leftmost value in the last row of the tree.
     *
     * Example 1:
     * Input:
     *
     *     2
     *    / \
     *   1   3
     *
     * Output:
     * 1
     * Example 2:
     * Input:
     *
     *         1
     *        / \
     *       2   3
     *      /   / \
     *     4   5   6
     *        /
     *       7
     *
     * Output:
     * 7
     * Note: You may assume the tree (i.e., the given root node) is not NULL.
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int findBottomLeftValue(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int index = 0;
            int depth = depth(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                index++;
                if (index == depth) {
                    System.out.println("depth :" + depth);
                    return queue.poll().val;
                }
                while (size-- > 0) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            return 0;
        }

        int depth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            return Math.max(depth(root.left), depth(root.right)) + 1;
        }
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution2 {
        public int findBottomLeftValue(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int index = 0;
            TreeNode first = null;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (i == 0) {
                        first = node;
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            return first.val;
        }
    }
}
