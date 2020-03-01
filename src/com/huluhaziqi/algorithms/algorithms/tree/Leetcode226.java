package com.huluhaziqi.algorithms.algorithms.tree;

public class Leetcode226 {

    /**
     * 226. Invert Binary Tree
     * Easy
     *
     * 2560
     *
     * 41
     *
     * Add to List
     *
     * Share
     * Invert a binary tree.
     *
     * Example:
     *
     * Input:
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * Output:
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     * Trivia:
     * This problem was inspired by this original tweet by Max Howell:
     *
     * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
     * Accepted
     * 420,198
     * Submissions
     * 680,607
     */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            invert(root);
            return root;
        }

        TreeNode invert(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode left = invert(root.left);
            TreeNode right = invert(root.right);
            root.left = right;
            root.right = left;
            return root;
        }
    }
}
