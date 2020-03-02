package com.huluhaziqi.algorithms.algorithms.tree;

public class Leetcode337 {

    /** leetcode 337
     * 337. House Robber III
     * Medium
     *
     * 2130
     *
     * 46
     *
     * Add to List
     *
     * Share
     * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.
     *
     * Determine the maximum amount of money the thief can rob tonight without alerting the police.
     *
     * Example 1:
     *
     * Input: [3,2,3,null,3,null,1]
     *
     *      3
     *     / \
     *    2   3
     *     \   \
     *      3   1
     *
     * Output: 7
     * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
     * Example 2:
     *
     * Input: [3,4,5,1,3,null,1]
     *
     *      3
     *     / \
     *    4   5
     *   / \   \
     *  1   3   1
     *
     * Output: 9
     * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int rob(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int result = root.val;
            if (root.left != null) {
                result += rob(root.left.left) + rob(root.left.right);
            }
            if (root.right != null) {
                result += rob(root.right.left) + rob(root.right.right);
            }
            return Math.max(result, rob(root.left) + rob(root.right));
        }
    }
}
