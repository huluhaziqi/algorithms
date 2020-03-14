package com.huluhaziqi.algorithms.algorithms.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class leetcode653 {
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
        public boolean findTarget(TreeNode root, int target) {
            if (root == null) {
                return false;
            }
            List<Integer> result = build(root);
            int size = result.size();
            int l = 0;
            int h = size - 1;
            while (l < h) {
                int tem = result.get(l) + result.get(h);
                if (tem == target) {
                    return true;
                }
                if (tem < target) {
                    l++;
                } else {
                    h--;
                }
            }
            return false;
        }

        List<Integer> build(TreeNode root) {
            if (root == null) {
                return null;
            }
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = root;
            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
                TreeNode tem = stack.pop();
                result.add(tem.val);
                if (tem.right != null) {
                    node = tem.right;
                }
            }
            return result;
        }
    }
}
