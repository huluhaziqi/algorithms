package com.huluhaziqi.algorithms.algorithms.tree;

public class IsBalanced {

    /**
     * 110. Balanced Binary Tree
     * Easy
     * <p>
     * 1786
     * <p>
     * 146
     * <p>
     * Add to List
     * <p>
     * Share
     * Given a binary tree, determine if it is height-balanced.
     * <p>
     * For this problem, a height-balanced binary tree is defined as:
     * <p>
     * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Given the following tree [3,9,20,null,null,15,7]:
     * <p>
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * Return true.
     * <p>
     * Example 2:
     * <p>
     * Given the following tree [1,2,2,3,3,null,null,4,4]:
     * <p>
     * 1
     * / \
     * 2   2
     * / \
     * 3   3
     * / \
     * 4   4
     * Return false.
     * <p>
     * Accepted
     * 401,914
     * Submissions
     * 944,428
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return judge(root.left, root.right) && isBalanced(root.left) && isBalanced(root.right);
    }


    boolean judge(TreeNode root1, TreeNode root2) {
        return Math.abs(depth(root1) - depth(root2)) <= 1;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        depth++;
        depth = Math.max(depth(root.left), depth(root.right));
        return depth;
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
        public boolean isBalanced(TreeNode root) {
            return judge(root);
        }

        boolean judge(TreeNode root) {
            if (root == null) {
                return true;
            }
            int depthleft = depth(root.left);
            int depthRight = depth(root.right);
            if (Math.abs(depthleft - depthRight) <= 1 && judge(root.left) && judge(root.right)) {
                return true;
            }
            return false;
        }

        int depth(TreeNode node) {
            if (node == null) {
                return 0;
            }
            return Math.max(depth(node.left), depth(node.right)) + 1;
        }
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
    class Solution2 {
        public boolean isBalanced(TreeNode root) {
            depth(root);
            return result;
        }

        boolean result = true;

        int depth(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int depthleft = depth(node.left);
            int depthright = depth(node.right);
            if (Math.abs(depthleft - depthright) > 1) {
                result = false;
            }
            return Math.max(depthleft, depthright) + 1;

        }
    }
}
