package com.huluhaziqi.algorithms.algorithms.tree;

public class Leetcode687 {

    /**
     *
     * 687. Longest Univalue Path
     * Easy
     *
     * 1359
     *
     * 368
     *
     * Add to List
     *
     * Share
     * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
     *
     * The length of path between two nodes is represented by the number of edges between them.
     *
     *
     *
     * Example 1:
     *
     * Input:
     *
     *               5
     *              / \
     *             4   5
     *            / \   \
     *           1   1   5
     * Output: 2
     *
     *
     *
     * Example 2:
     *
     * Input:
     *
     *               1
     *              / \
     *             4   5
     *            / \   \
     *           4   4   5
     * Output: 2
     *
     *
     *
     * Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        int max = 0;

        public int longestUnivaluePath(TreeNode root) {
            if (root == null) {
                return 0;
            }
            longest(root);
            return max;
        }

        int longest(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int ret = 0;
            int left = longest(root.left);
            int right = longest(root.right);
            if (root.left != null) left = root.left.val == root.val ? left + 1 : 0;
            if (root.right != null) right = root.right.val == root.val ? right + 1 : 0;
            max = Math.max((left + right), max);
            return Math.max(left, right);
        }
    }
}
