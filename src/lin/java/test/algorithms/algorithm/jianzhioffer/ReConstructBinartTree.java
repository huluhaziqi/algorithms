package lin.java.test.algorithms.algorithm.jianzhioffer;

public class ReConstructBinartTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode node = new ReConstructBinartTree().reConstructBinaryTree(pre, in);

    }

    /**
     * Definition for binary tree
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        return constructTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode constructTree(int[] pre, int start1, int end1, int[] in, int start2, int end2) {

        if (start1 > end1) {
            return null;
        }
        TreeNode root = new TreeNode(pre[start1]);
        int rootIndex = findIndex(pre, start1, in, start2, end2);
        int leftSize = rootIndex - start2;
        root.left = constructTree(pre, start1 + 1, start1 + leftSize, in, start2, start2 + leftSize - 1);
        root.right = constructTree(pre, start1 + leftSize + 1, end1, in, start2 + leftSize + 1, end2);
        return root;
    }

    public int findIndex(int[] pre, int root, int[] in, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (pre[root] == in[i]) {
                return i;
            }
        }
        return -1;
    }
}
