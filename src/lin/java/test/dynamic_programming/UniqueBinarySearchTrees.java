package lin.java.test.dynamic_programming;

import java.util.ArrayList;

public class UniqueBinarySearchTrees {

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public ArrayList<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private ArrayList<TreeNode> generate(int start, int end) {
        ArrayList<TreeNode> rst = new ArrayList<TreeNode>();

        if (start > end) {
            rst.add(null);
            return rst;
        }

        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> left = generate(start, i - 1);
            ArrayList<TreeNode> right = generate(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    // should new a root here because it need to
                    // be different for each tree
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    rst.add(root);
                }
            }
        }
        return rst;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        int n = 1;
        uniqueBinarySearchTrees.generateTrees(n);
    }
}
