package com.huluhaziqi.algorithms.algorithms.divideAndConquer;

import java.util.ArrayList;
import java.util.List;

public class LeetCode95 {

    ///*    *//**
//     * Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public List<TreeNode> generateTrees(int n) {
            if (n <= 0) {
                return null;
            }
            return generate(1, n);
        }

        public List<TreeNode> generate(int s, int e) {
            if (s > e) {
                return null;
            }
            List<TreeNode> list = new ArrayList<>();
            if (s == e) {
                list.add(new TreeNode(s));
                return list;
            }

            for (int i = s; i <= e; i++) {
                List<TreeNode> left = generate(s, i);
                List<TreeNode> right = generate(i + 1, e);
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode root = new TreeNode(i);
                        root.left = l;
                        root.right = r;
                        list.add(root);
                    }
                }
            }
            return list;
        }
    }
}
