package lin.java.test.algorithms.tree;

import java.util.LinkedList;

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
            TreeNode top = queue.getFirst();
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

    boolean judge(TreeNode child, LinkedList linkedList) {
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
