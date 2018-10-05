package lin.java.test.algorithms.algorithm.jianzhioffer;

import java.util.ArrayList;

public class FindPath {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(12);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> result = FindPath1(treeNode,22);
    }
    public static ArrayList<ArrayList<Integer>> FindPath1(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        getSum(root, new ArrayList<Integer>(), 0, target, result);
        return result;
    }

    public static void getSum(TreeNode node, ArrayList<Integer> value, int cur, int target, ArrayList<ArrayList<Integer>> ret) {
        if (node == null) {
            if (cur == target) {
                ret.add(new ArrayList<>(value));
            }
            return;
        }
        value.add(node.val);
        cur += node.val;
        getSum(node.left, value, cur, target, ret);
        //cur -= node.val;
        //value.remove(value.size() - 1);
        //value.add(node.val);
        //cur += node.val;
        getSum(node.right, value, cur, target, ret);
        cur -= node.val;
        value.remove(value.size() - 1);
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}

