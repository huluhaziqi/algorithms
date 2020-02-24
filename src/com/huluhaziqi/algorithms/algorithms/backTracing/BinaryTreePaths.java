package com.huluhaziqi.algorithms.algorithms.backTracing;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.right = right;
        root.left = left;
        left.right = new TreeNode(5);
        List<String> result = new BinaryTreePaths().binaryTreePaths2(root);
        for (String s : result) {
            System.out.println(s);
        }

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        backTracing(root, new String(), paths);
        return paths;
    }

    public void backTracing(TreeNode root, String value, List<String> paths) {
        if (root == null) {
            return;
        }
        value += (String.valueOf(root.val));
        if (isLeaf(root)) {
            paths.add(value);
        }
        backTracing(root.left, value, paths);
        backTracing(root.right, value, paths);
    }

    public void backTracing2(TreeNode root, List<String> value, List<String> paths) {
        if (root == null) {
            return;
        }
        value.add(String.valueOf(root.val));
        if (isLeaf(root)) {
            paths.add(buildPath(value));
        }
        backTracing2(root.left, value, paths);
        backTracing2(root.right, value, paths);
        value.remove(value.size() - 1);
    }

    public String buildPath(List<String> value) {
        if (value == null || value.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean first = true;
        for (String v : value) {
            if (first) {
                stringBuilder.append(v);
                first = false;
            } else {
                stringBuilder.append("->" + v);
            }
        }
        return stringBuilder.toString();
    }

    boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<String> binaryTreePaths2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<String>> ret = new ArrayList<>();
        dfs(root, ret, new ArrayList<>());
        List<String> result = new ArrayList<>();
        for (List<String> r : ret) {
            String tem = "";
            int i = 0;
            for (String s : r) {
                if (i == 0) {
                    tem += s;
                } else {
                    tem += "->" + s;
                }
                i++;
            }
            result.add(tem);
        }
        return result;
    }

    public void dfs(TreeNode root, List<List<String>> ret, List<String> list) {
        if (root == null) {
            return;
        }
        list.add(String.valueOf(root.val));
        if (root.right == null && root.left == null) {
            ret.add(new ArrayList<>(list));
            return;
        }
        dfs(root.left, ret, list);
        dfs(root.right, ret, list);
//        list.remove(list.size() - 1);
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            dfs(root, "", result);
            return result;
        }

        void dfs(TreeNode node, String out, List<String> result) {
            if (node == null) {
                return;
            }
            if (node.left == null && node.right == null) {
                result.add(out + node.val);
                return;
            }
            String tem = node.val + "->";
            dfs(node.left, out + tem, result);
            dfs(node.right, out + tem, result);
        }

    }

}
