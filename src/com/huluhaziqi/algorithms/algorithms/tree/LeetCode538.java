package com.huluhaziqi.algorithms.algorithms.tree;

import java.util.Stack;

public class LeetCode538 {

    /**
     * 538. Convert BST to Greater Tree
     * Easy
     * <p>
     * 1657
     * <p>
     * 108
     * <p>
     * Add to List
     * <p>
     * Share
     * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
     * <p>
     * Example:
     * <p>
     * Input: The root of a Binary Search Tree like this:
     * 5
     * /   \
     * 2     13
     * <p>
     * Output: The root of a Greater Tree like this:
     * 18
     * /   \
     * 20     13
     * Note: This question is the same as 1038: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
     * <p>
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

    class Solution2 {
        public TreeNode convertBST(TreeNode root) {
            if (root == null) {
                return null;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            int sum = 0;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.right;
                }
                TreeNode node = stack.pop();
                sum += node.val;
                node.val = sum;
                if (node.left != null) {
                    cur = node.left;
                }
            }
            return root;
        }
    }
}
