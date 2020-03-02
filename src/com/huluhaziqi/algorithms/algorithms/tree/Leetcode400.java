package com.huluhaziqi.algorithms.algorithms.tree;

public class Leetcode400 {

    /**
     * 404. Sum of Left Leaves
     * Easy
     * <p>
     * 904
     * <p>
     * 102
     * <p>
     * Add to List
     * <p>
     * Share
     * Find the sum of all left leaves in a given binary tree.
     * <p>
     * Example:
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * <p>
     * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
     * Accepted
     * 156,219
     * Submissions
     * 311,003
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return leave(root, false);
        }

        int leave(TreeNode node, boolean flag) {
            if (node == null) {
                return 0;
            }
            int ret = 0;
            if (flag && node.left == null && node.right == null) {
                ret += node.val;
            }
            ret += leave(node.left, true);
            ret += leave(node.right, false);
            return ret;
        }
    }

    class Solution2 {
        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            if (isleaf(root.left)) {
                return root.left.val + sumOfLeftLeaves(root.right);
            }
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }

        boolean isleaf(TreeNode root) {
            if (root == null) {
                return false;
            }
            if (root.left == null && root.right == null) {
                return true;
            }
            return false;
        }
    }
}
