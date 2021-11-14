package com.huluhaziqi.algorithms.algorithms.tree;

public class LeetCode107 {

    class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if (root == null) {
                return new ArrayList<>();
            }
            Queue<TreeNode> s = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            s.offer(root);
            while (!s.isEmpty()) {
                List<Integer> tmp = new ArrayList<>();
                int size = s.size();
                for (int i = 0; i < size; i++) {
                    TreeNode top = s.poll();
                    tmp.add(top.val);
                    if (top.left != null) {
                        s.offer(top.left);
                    }
                    if (top.right != null) {
                        s.offer(top.right);
                    }
                }
                res.add(tmp);
            }
            Collections.reverse(res);
            return res;
        }
    }
}
