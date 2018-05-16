package lin.java.test.algorithms.backTracing;

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
        List<String> result = new BinaryTreePaths().binaryTreePaths(root);
        for(String s:result){
            System.out.println(s);
        }

    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        backTracing(root, new String(), paths);
        return paths;
    }

    public void backTracing(TreeNode root ,String value,List<String> paths){
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

}
