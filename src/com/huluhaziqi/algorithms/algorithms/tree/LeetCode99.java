package com.huluhaziqi.algorithms.algorithms.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode99 {

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
    class Solution {
        public void recoverTree(TreeNode root) {
            if (root == null) {
                return;
            }
            List<Integer> list = new ArrayList<>();
            inorder(root, list);
            int[] index = find(list);
            recover(root, index[0], index[1]);

        }

        public void recover(TreeNode root, int x, int y) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            int index = 0;
            while (!q.isEmpty()) {
                TreeNode top = q.poll();
                if (top.val == x || top.val == y) {
                    top.val = top.val == x ? y : x;
                    index++;

                }
                if (index >= 2) {
                    break;
                }
                if (top.left != null) {
                    q.offer(top.left);
                }
                if (top.right != null) {
                    q.offer(top.right);
                }

            }
        }

        public void inorder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }

        public int[] find(List<Integer> list) {
            if (list == null || list.size() == 0) {
                return new int[0];
            }
            int index1 = -1, index2 = -1;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    index2 = i + 1;
                    if (index1 == -1) {
                        index1 = i;
                    } else {
                        break;
                    }
                }
            }
            int x = list.get(index1);
            int y = list.get(index2);
            return new int[]{x, y};
        }
    }
}
