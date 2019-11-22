package com.huluhaziqi.algorithms.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompleteTree {

    public static void main(String[] args) {

    }

    public boolean checkCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode top = queue.pollFirst();
            if (!judge(top.left, queue)) {
                return false;
            }
            if (!judge(top.right, queue)) {
                return false;
            }
        }

        return true;
    }

    boolean last = false;

    boolean judge(TreeNode child, Queue linkedList) {
        if (child != null) {
            if (!last) {
                linkedList.add(child);
            } else {
                return false;
            }
        } else {
            last = true;
        }
        return true;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
