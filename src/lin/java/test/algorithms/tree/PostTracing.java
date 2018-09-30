package lin.java.test.algorithms.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostTracing {

    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<Integer> result = new Solution().postorderTraversal(root);
        result.forEach(o -> {
            System.out.println(o);
        });
    }

    public static class Solution {
        /**
         * @param root: A Tree
         * @return: Postorder in ArrayList which contains node values.
         */
        public List<Integer> postorderTraversal(TreeNode root) {
            // write your code here
            if (root == null) {
                return new ArrayList<>();
            }
            List<Integer> list = new ArrayList<>();
            TreeNode lastVisit = null;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (node.right != null && node.right != lastVisit) {
                    stack.push(node);
                    TreeNode right = node.right;
                    while (right != null) {
                        stack.push(right);
                        right = right.left;
                    }
                } else {
                    lastVisit = node;
                    list.add(node.val);
                }
            }
            return list;
        }

        public List<Integer> postOrder2(TreeNode node) {
            if (node == null) {
                return null;
            }
            List<Integer> result = new ArrayList<Integer>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode lastVisit = null;
//
            return null;
        }
    }
}
