package com.huluhaziqi.algorithms.algorithms.tree;

public class Leetcode236 {

    /**
     * 236. Lowest Common Ancestor of a Binary Tree
     * Medium
     * <p>
     * 2976
     * <p>
     * 161
     * <p>
     * Add to List
     * <p>
     * Share
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
     * <p>
     * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
     * <p>
     * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
     * <p>
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * Output: 3
     * Explanation: The LCA of nodes 5 and 1 is 3.
     * Example 2:
     * <p>
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * Output: 5
     * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
     * <p>
     * <p>
     * Note:
     * <p>
     * All of the nodes' values will be unique.
     * p and q are different and both values will exist in the binary tree.
     * Accepted
     * 397,389
     * Submissions
     * 930,394
     */
    class Solution2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) {
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);

            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (left == null) {
                return right;
            } else if (right == null) {
                return left;
            }
            return root;
        }
    }
}
