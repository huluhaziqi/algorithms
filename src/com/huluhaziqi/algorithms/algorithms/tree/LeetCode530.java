package com.huluhaziqi.algorithms.algorithms.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode530 {

    /**
     * 530. Minimum Absolute Difference in BST
     * Easy
     *
     * 701
     *
     * 58
     *
     * Add to List
     *
     * Share
     * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
     *
     * Example:
     *
     * Input:
     *
     *    1
     *     \
     *      3
     *     /
     *    2
     *
     * Output:
     * 1
     *
     * Explanation:
     * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
     *
     *
     * Note:
     *
     * There are at least two nodes in this BST.
     * This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
     * Accepted
     * 78,450
     * Submissions
     * 149,509
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int getMinimumDifference(TreeNode root) {
            int result = build(root);
            if (result == -1) {
                return 0;
            }
            return min;

        }

        int min = Integer.MAX_VALUE;

        int build(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) {
                return -1;
            }
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = root;
            TreeNode cur = null;
            TreeNode pre = null;
            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
                pre = cur;
                TreeNode tem = stack.pop();
                cur = tem;
                if (pre != null) {
                    min = Math.min(Math.abs(pre.val - cur.val), min);
                }
                result.add(tem.val);
                if (tem.right != null) {
                    node = tem.right;
                }
            }
            return 0;
        }
    }
}
