package com.huluhaziqi.algorithms.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode111 {

    /**
     * 111. Minimum Depth of Binary Tree
     * Easy
     * <p>
     * 1056
     * <p>
     * 596
     * <p>
     * Add to List
     * <p>
     * Share
     * Given a binary tree, find its minimum depth.
     * <p>
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     * <p>
     * Note: A leaf is a node with no children.
     * <p>
     * Example:
     * <p>
     * Given binary tree [3,9,20,null,null,15,7],
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * return its minimum depth = 2.
     * <p>
     * Accepted
     * 368,957
     * Submissions
     * 1,008,225
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size();
            while (size-- > 0) {
                TreeNode top = queue.poll();
                if (top.left == null && top.right == null) {
                    return depth;
                }
                if (top.left != null) {
                    queue.offer(top.left);
                }
                if (top.right != null) {
                    queue.offer(top.right);
                }
            }
        }
        return 0;
    }

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
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return depth(root);

        }

        int depth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int depth1 = depth(root.left);
            int depth2 = depth(root.right);
            if (depth1 == 0 || depth2 == 0) {
                return depth1 + depth2 + 1;
            }
            return Math.min(depth1, depth2) + 1;

        }
    }
}
