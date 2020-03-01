package com.huluhaziqi.algorithms.algorithms.tree;

public class Leetcode543 {

    /**
     * 543. Diameter of Binary Tree
     * Easy
     *
     * 2189
     *
     * 140
     *
     * Add to List
     *
     * Share
     * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
     *
     * Example:
     * Given a binary tree
     *           1
     *          / \
     *         2   3
     *        / \
     *       4   5
     * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
     *
     * Note: The length of path between two nodes is represented by the number of edges between them.
     *
     * Accepted
     * 211,183
     * Submissions
     * 437,764
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
        public int diameterOfBinaryTree(TreeNode root) {
            depth(root);
            return result;
        }

        int result = 0;

        int depth(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int depthl = depth(node.left);
            int depthr = depth(node.right);
            if (depthl + depthr > result) {
                result = depthl + depthr;
            }
            return Math.max(depthl, depthr) + 1;
        }
    }
}
