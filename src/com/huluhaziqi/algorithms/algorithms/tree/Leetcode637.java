package com.huluhaziqi.algorithms.algorithms.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode637 {
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
        public List<Double> averageOfLevels(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            List<Double> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                int tem = size;
                double subAvg = 0.0;
                while (size-- > 0) {
                    TreeNode node = queue.poll();
                    subAvg += node.val;
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
                subAvg = subAvg / (tem * 1.0);
                result.add(subAvg);
            }
            return result;
        }
    }
}
