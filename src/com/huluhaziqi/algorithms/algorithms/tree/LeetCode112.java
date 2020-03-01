package com.huluhaziqi.algorithms.algorithms.tree;

import sun.reflect.generics.tree.Tree;

import java.util.List;

public class LeetCode112 {
    /**
     * 112. Path Sum
     * Easy
     * <p>
     * 1445
     * <p>
     * 427
     * <p>
     * Add to List
     * <p>
     * Share
     * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
     * <p>
     * Note: A leaf is a node with no children.
     * <p>
     * Example:
     * <p>
     * Given the below binary tree and sum = 22,
     * <p>
     * 5
     * / \
     * 4   8
     * /   / \
     * 11  13  4
     * /  \      \
     * 7    2      1
     * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
     * <p>
     * Accepted
     * 411,251
     * Submissions
     * 1,031,085
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        Solution solution = new Solution();
        solution.hasPathSum(treeNode, 1);
    }

    static /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean hasPathSum(TreeNode root, int sum) {
            if (root == null) {
                return false;
            }
            bfs(root, sum, 0, null);
            return result;
        }

        boolean result = false;

        void bfs(TreeNode current, int sum, int value, List<TreeNode> list) {
            if (current == null) {
                return;
            }
            if (current.left == null && current.right == null) {
                if (value + current.val == sum) {
                    result = true;
                }
                return;
            }
            bfs(current.left, sum, value + current.val, list);
            bfs(current.right, sum, value + current.val, list);
        }
    }
}
