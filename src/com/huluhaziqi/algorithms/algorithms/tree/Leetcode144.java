package com.huluhaziqi.algorithms.algorithms.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Leetcode144 {
    /**
     * 144. Binary Tree Preorder Traversal
     * Medium
     *
     * 1202
     *
     * 51
     *
     * Add to List
     *
     * Share
     * Given a binary tree, return the preorder traversal of its nodes' values.
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
     * Output: [1,2,3]
     * Follow up: Recursive solution is trivial, could you do it iteratively?
     *
     * Accepted
     * 438,281
     * Submissions
     * 810,749
     */
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> result = new ArrayList<>();

            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
            return result;
        }


    }
}
