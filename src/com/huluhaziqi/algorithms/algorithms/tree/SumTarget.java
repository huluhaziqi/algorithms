package com.huluhaziqi.algorithms.algorithms.tree;

import java.util.ArrayList;
import java.util.List;

public class SumTarget {

    /**
     * Definition of TreeNode:
     * public class TreeNode {
     * public int val;
     * public TreeNode left, right;
     * public TreeNode(int val) {
     * this.val = val;
     * this.left = this.right = null;
     * }
     * }
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        List<List<Integer>> result = new SumTarget.Solution().binaryTreePathSum(root, 5);
        result.forEach(o -> {
            o.forEach(l -> {
                System.out.print(l + " ");
            });
            System.out.println();
        });
    }

    public static class Solution {
        /*
         * @param root: the root of binary tree
         * @param target: An integer
         * @return: all valid paths
         */
        public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
            // write your code here
            if (root == null) {
                return new ArrayList<>();
            }
            List<List<Integer>> ret = new ArrayList<>();
            sum(new ArrayList<Integer>(), root, target, ret);
            return ret;
        }

        public void sum(List<Integer> list, TreeNode root, int target, List<List<Integer>> ret) {
            list.add(root.val);
            target = target - root.val;
            if (root.left == null && root.right == null && target == 0) {
                ret.add(new ArrayList<>(list));
                return;
            }
            if (root.left != null) {
                sum(list, root.left, target, ret);
                list.remove(list.size() - 1);
            }
            if (root.right != null) {
                sum(list, root.right, target, ret);
                list.remove(list.size() - 1);
            }

        }
    }
}
