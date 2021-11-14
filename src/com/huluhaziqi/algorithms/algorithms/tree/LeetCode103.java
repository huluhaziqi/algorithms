package com.huluhaziqi.algorithms.algorithms.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class LeetCode103 {
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            LinkedList<TreeNode> s = new LinkedList<>();
            int level = 0;
            s.add(root);
            List<List<Integer>> result = new ArrayList<>();
            while (!s.isEmpty()) {
                int size = s.size();
                List<Integer> res = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode top = s.poll();
                    if (level % 2 == 1) {
                        res.add(0, top.val);
                    } else {
                        res.add(top.val);
                    }
                    if (top.left != null) {
                        s.offer(top.left);
                    }
                    if (top.right != null) {
                        s.offer(top.right);
                    }

                }
                result.add(res);
                level++;
            }
            return result;
        }
    }
}