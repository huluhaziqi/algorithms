package lin.java.test.algorithms.jianzhioffer;

public class Solution4 {

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int in[] = {4,7,2,1,5,3,8,6};
        TreeNode result = new Solution4().reConstructBinaryTree(pre,in);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null) {
            return null;
        }
        return f(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    TreeNode f(int[] pre, int s1, int e1, int[] in, int s2, int e2) {
        if (pre == null || s1 > e1 || in == null || s2 > e2) {
            return null;
        }
        TreeNode root = new TreeNode(pre[s1]);
        int index = find(pre[s1], in, s2, e2);
        int len = index - s2;
        root.left = f(pre, s1 + 1, s1 + len, in, s2, s2 + len - 1);
        root.right = f(pre, s1 + len + 1, e1, in, s2 + len + 1, e2);
        return root;
    }

    int find(int target, int[] in, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (in[i] == target) {
                return i;
            }
        }
        return 0;
    }
}
