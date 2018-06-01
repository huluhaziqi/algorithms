package lin.java.test.algorithms.tree;

public class IsBalanced {
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
}
