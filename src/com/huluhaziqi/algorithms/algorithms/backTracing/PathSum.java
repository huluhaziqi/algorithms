package com.huluhaziqi.algorithms.algorithms.backTracing;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ret = new ArrayList<>();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.right = null;
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        ret =  pathSum(root,22);
    }
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<List<Integer>> ret = new ArrayList<>();
        dfs(root, 0, sum, new ArrayList<>(), ret);
        return ret;
    }

    public static void dfs(TreeNode node, int value, int sum, List<Integer> temp, List<List<Integer>> ret) {
        if (node == null) {
            return;
        }
        temp.add(node.val);
        if ((value + node.val == sum) && node.left == null && node.right == null) {
            ret.add(new ArrayList<>(temp));
            return;
        }
        dfs(node.left, value + node.val, sum, temp, ret);
        dfs(node.right, value + node.val, sum, temp, ret);
        temp.remove(temp.size() - 1);
    }
}
