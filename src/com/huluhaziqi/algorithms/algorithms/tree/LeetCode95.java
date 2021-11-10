package com.huluhaziqi.algorithms.algorithms.tree;

import java.util.ArrayList;
import java.util.List;

public class LeetCode95 {


    class Solution {
        public List<TreeNode> generateTrees(int n) {
            if (n < 1) {
                return new ArrayList<>();
            }
            return generate(1, n);
        }

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        public List<TreeNode> generate(int s, int e) {
            List<TreeNode> list = new ArrayList<>();
            if (s > e) {
                list.add(null);
                return list;
            }
            for (int i = s; i <= e; i++) {
                List<TreeNode> left = generate(s, i - 1);
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
