package com.huluhaziqi.algorithms.algorithms.tree;

public class LeetCode538 {

    /**
     * 538. Convert BST to Greater Tree
     * Easy
     *
     * 1657
     *
     * 108
     *
     * Add to List
     *
     * Share
     * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
     *
     * Example:
     *
     * Input: The root of a Binary Search Tree like this:
     *               5
     *             /   \
     *            2     13
     *
     * Output: The root of a Greater Tree like this:
     *              18
     *             /   \
     *           20     13
     * Note: This question is the same as 1038: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
     *
     * Accepted
     * 106,209
     * Submissions
     * 197,885
     */
    class Solution {
        public TreeNode convertBST(TreeNode root) {
            if (root == null) {
                return null;
            }
            count(root);
            return root;
        }

        int sum = 0;

        void count(TreeNode node) {
            if (node == null) {
                return;
            }
            count(node.right);
            sum += node.val;
            node.val = sum;
            count(node.left);
        }

    }
}
