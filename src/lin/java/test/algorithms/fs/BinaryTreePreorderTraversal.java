package lin.java.test.algorithms.fs;

import java.util.*;

public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> result = new BinaryTreePreorderTraversal().preorderTraversal(root);
        result.forEach(o->{
            System.out.print(o + " ");
        });
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
        Collections.reverse(result);
        return  result;
    }

    public static class TreeNode{
        private int val;
        private TreeNode right;
        private TreeNode left;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
