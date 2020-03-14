package com.huluhaziqi.algorithms.algorithms.tree;

import java.util.*;

public class Leetcode501 {
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
        public int[] findMode(TreeNode root) {
            search(root);
            int[] ret = new int[map.size()];
            int index = 0;
            Set<Map.Entry<Integer, Integer>> sets = map.entrySet();
            for (Map.Entry entry : sets) {
                if (max == (int) entry.getValue()) {
                    ret[index++] = (int) entry.getKey();
                }
            }
            return ret;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        void search(TreeNode root) {
            if (root == null) {
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = root;
            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
                TreeNode tem = stack.pop();
                if (map.containsKey(tem.val)) {
                    map.put(tem.val, map.get(tem.val) + 1);
                } else {
                    map.put(tem.val, 1);
                }
                max = Math.max(max, map.get(tem.val));
                if (tem.right != null) {
                    node = tem.right;
                }
            }

        }
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
    class Solution2 {
        public int[] findMode(TreeNode root) {
            search(root);
            int[] res = new int[ret.size()];
            int index = 0;
            for (int i = 0; i < res.length; i++) {
                res[i] = ret.get(i);
            }
            return res;
        }

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ret = new ArrayList<>();
        int max = 0;

        void search(TreeNode root) {
            if (root == null) {
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = root;
            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
                TreeNode tem = stack.pop();
                if (map.containsKey(tem.val)) {
                    map.put(tem.val, map.get(tem.val) + 1);
                } else {
                    map.put(tem.val, 1);
                }
                if (map.get(tem.val) > max) {
                    ret.clear();
                    ret.add(tem.val);
                    max = map.get(tem.val);
                } else if (map.get(tem.val) == max) {
                    ret.add(tem.val);
                }
                if (tem.right != null) {
                    node = tem.right;
                }
            }
        }
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
    class Solution3 {
        private int max = 1;
        List<Integer> ret = new ArrayList<>();

        public int[] findMode(TreeNode root) {
            inOrder(root);
            int[] res = new int[ret.size()];
            int idx = 0;
            for (int num : ret) {
                res[idx++] = num;
            }
            return res;
        }

        void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = root;
            TreeNode pre = null;
            TreeNode cur = null;
            int cnt = 1;
            while (node != null || !stack.isEmpty()) {
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
                pre = cur;
                TreeNode tem = stack.pop();
                cur = tem;
                if (pre != null) {
                    if (pre.val == cur.val) {
                        cnt++;
                    } else {
                        cnt = 1;
                    }
                }
                if (cnt > max) {
                    ret.clear();
                    ret.add(cur.val);
                    max = cnt;
                } else if (cnt == max) {
                    ret.add(cur.val);
                }
                if (tem.right != null) {
                    node = tem.right;
                }
            }
        }
    }
}
