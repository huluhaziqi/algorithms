package com.huluhaziqi.algorithms.algorithms.tree;

import java.util.Stack;

public class LeetCode230 {

    /**
     * 230. Kth Smallest Element in a BST
     * Medium
     *
     * 1844
     *
     * 53
     *
     * Add to List
     *
     * Share
     * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
     *
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
     *
     * Example 1:
     *
     * Input: root = [3,1,4,null,2], k = 1
     *    3
     *   / \
     *  1   4
     *   \
     *    2
     * Output: 1
     * Example 2:
     *
     * Input: root = [5,3,6,2,4,null,null,1], k = 3
     *        5
     *       / \
     *      3   6
     *     / \
     *    2   4
     *   /
     *  1
     * Output: 3
     * Follow up:
     * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
     *
     * Accepted
     * 308,781
     * Submissions
     * 550,565
     */
    class Solution {
        public int kthSmallest(TreeNode root, int k) {
            if (root == null) {
                return 0;
            }
            Stack<TreeNode> stack = new Stack<>();
            // stack.push(root);
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                TreeNode node = stack.pop();
                if (--k == 0) {
                    return node.val;
                }
                if (node.right != null) {
                    root = node.right;
                }
            }
            return 0;
        }
    }
}
