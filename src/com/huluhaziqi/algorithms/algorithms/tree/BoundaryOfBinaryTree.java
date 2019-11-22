package com.huluhaziqi.algorithms.algorithms.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BoundaryOfBinaryTree {

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
    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.left = new TreeNode(5);
        root.right.right.right.left.right = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(10);
        System.out.println(new BoundaryOfBinaryTree().boundaryOfBinaryTree(root));
    }


    /**
     * @param root: a TreeNode
     * @return: a list of integer
     */
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        List<Integer> third = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode f = queue.removeFirst();
                if (f.left != null) {
                    queue.add(f.left);
                }
                if (f.right != null) {
                    queue.add(f.right);
                }
                if (i == 0) {
                    first.add(f.val);
                }
                if (i == size - 1) {
                    third.add(f.val);
                }
                if (f.left == null && f.right == null) {
                    second.add(f.val);
                }
            }
        }
        list.addAll(first);
        list.addAll(second);
        list.addAll((third));
        return list;
    }
}
