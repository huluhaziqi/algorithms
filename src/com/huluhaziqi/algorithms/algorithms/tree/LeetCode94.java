package com.huluhaziqi.algorithms.algorithms.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode94 {

    /**
     * 94. Binary Tree Inorder Traversal
     * Medium
     *
     * 2523
     *
     * 106
     *
     * Add to List
     *
     * Share
     * Given a binary tree, return the inorder traversal of its nodes' values.
     *
     * Example:
     *
     * Input: [1,null,2,3]
     *    1
     *     \
     *      2
     *     /
     *    3
     *
     * Output: [1,3,2]
     * Follow up: Recursive solution is trivial, could you do it iteratively?
     *
     * Accepted
     * 636,756
     * Submissions
     * 1,044,468
     */
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ret = new ArrayList<>();
            if (root == null) {
                return ret;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
                TreeNode node = stack.pop();
                ret.add(node.val);
                if (node.right != null) {
                    cur = node.right;
                }
            }
            return ret;
        }
    }
}
