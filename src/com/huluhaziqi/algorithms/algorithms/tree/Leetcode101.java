package com.huluhaziqi.algorithms.algorithms.tree;

public class Leetcode101 {

    /**
     * 101. Symmetric Tree
     * Easy
     * <p>
     * 3294
     * <p>
     * 79
     * <p>
     * Add to List
     * <p>
     * Share
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     * <p>
     * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
     * <p>
     * 1
     * / \
     * 2   2
     * / \ / \
     * 3  4 4  3
     * <p>
     * <p>
     * But the following [1,2,2,null,3,null,3] is not:
     * <p>
     * 1
     * / \
     * 2   2
     * \   \
     * 3    3
     * <p>
     * <p>
     * Note:
     * Bonus points if you could solve it both recursively and iteratively.
     * <p>
     * Accepted
     * 556,002
     * Submissions
     * 1,218,009
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return symm(root.left, root.right);
        }

        boolean symm(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val == right.val) {
                return symm(left.left, right.right) && symm(left.right, right.left);
            }
            return false;
        }
    }
}
