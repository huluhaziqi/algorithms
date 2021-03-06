package com.huluhaziqi.algorithms.algorithms.tree;

public class Subtree {

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
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null) {
                return false;
            }
            return subtree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        boolean subtree(TreeNode s, TreeNode t) {
            if (s == null && t == null) return true;
            if (s == null || t == null) return false;
            if (s.val == t.val) {
                return subtree(s.left, t.left) && subtree(s.right, t.right);
            }
            return false;
        }
    }
}
