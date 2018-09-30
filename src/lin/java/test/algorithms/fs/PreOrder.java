package lin.java.test.algorithms.fs;

import java.util.List;

public class PreOrder {


    public static void main(String[] args) {
        InOrder.TreeNode root = new InOrder.TreeNode(1);
        root.right = new InOrder.TreeNode(2);
        root.right.left = new InOrder.TreeNode(3);
        List<Integer> result = new InOrder().inorderTraversal(root);
        result.forEach(o -> {
            System.out.print(o + " ");
        });
    }

    public static class TreeNode {
        int val;
        InOrder.TreeNode left;
        InOrder.TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preOrder(){
        return null;
    }
}
