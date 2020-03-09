package com.huluhaziqi.algorithms.algorithms.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LeetCode145 {

    class Solution {
        /**
         * 145. Binary Tree Postorder Traversal
         * Hard
         * <p>
         * 1394
         * <p>
         * 71
         * <p>
         * Add to List
         * <p>
         * Share
         * Given a binary tree, return the postorder traversal of its nodes' values.
         * <p>
         * Example:
         * <p>
         * Input: [1,null,2,3]
         * 1
         * \
         * 2
         * /
         * 3
         * <p>
         * Output: [3,2,1]
         * Follow up: Recursive solution is trivial, could you do it iteratively?
         * <p>
         * Accepted
         * 334,677
         * Submissions
         * 636,947
         *
         * @param root
         * @return
         */
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }

            }
            Collections.reverse(result);
            return result;
        }
    }

    import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> ret = new ArrayList<>();

            Stack<TreeNode> stack = new Stack<>();
            TreeNode lastVisited = null;
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                TreeNode node = stack.pop();
                if (node != null) {
                    if (node.right != null && node.right != lastVisited) {
                        stack.push(node);
                        TreeNode right = node.right;
                        while (right != null) {
                            stack.push(right);
                            right = right.left;
                        }
                    } else {
                        lastVisited = node;
                        ret.add(node.val);
                    }
                }
            }
            return ret;
        }
    }
