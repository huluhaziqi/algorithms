package com.huluhaziqi.algorithms.algorithms.tree;

public class LeetCode104 {

    /**
     * leetcode 104 tree depth
     * 104. Maximum Depth of Binary Tree
     * Easy
     * <p>
     * 2001
     * <p>
     * 66
     * <p>
     * Add to List
     * <p>
     * Share
     * Given a binary tree, find its maximum depth.
     * <p>
     * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     * <p>
     * Note: A leaf is a node with no children.
     * <p>
     * Example:
     * <p>
     * Given binary tree [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * return its depth = 3.
     * <p>
     * Accepted
     * 702,662
     * Submissions
     * 1,096,751
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            return depth(root);

        }

        int depth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return Math.max(depth(root.left), depth(root.right)) + 1;
        }
    }
}
