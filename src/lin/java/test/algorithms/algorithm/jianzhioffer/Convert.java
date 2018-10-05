package lin.java.test.algorithms.algorithm.jianzhioffer;

import java.util.Arrays;
import java.util.Stack;

public class Convert {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(6);
        treeNode.right = new TreeNode(14);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(12);
        treeNode.right.right = new TreeNode(16);
        Convert1(treeNode);
        StringBuilder sb = new StringBuilder();
        sb.length();
        String str = "dd";
        char[]  chars  = str.toCharArray();
        Arrays.sort(chars);
    }
    public static TreeNode Convert1(TreeNode pRootOfTree) {
        if(pRootOfTree == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = pRootOfTree;
        TreeNode pre = null;
        while(!stack.isEmpty() || temp != null ){
            while(temp != null){
                stack.push(temp);
                temp = temp.left;
            }
            TreeNode node = stack.pop();
            if(pre != null){
                pre.right = node;
            }
            node.left = pre;
            pre = node;
            temp = node.right;
        }
        while(pRootOfTree.left != null){
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }
}
