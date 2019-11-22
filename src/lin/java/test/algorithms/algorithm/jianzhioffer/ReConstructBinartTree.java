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

    public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null || pre.length == 0 || in.length == 0 ){
            return null;
        }
        return reConstruct(pre,0, pre.length - 1, in , 0, in.length -1);
    }
    
    public TreeNode reConstruct(int[] pre, int l1, int r1, int[] in, int l2, int r2){
        if(l1 > r1){
            return null;
        }
        if(l1 == r1){
            return new TreeNode(pre[l1]);
        }
        TreeNode root = new TreeNode(pre[l1]);
        int index = getIndex(in, l2, r2 , pre[l1]);
        if(index == -1){
            return null;
        }
        int len1 = index - l2;
        root.left = reConstruct(pre, l1 + 1, len1 + l1, in, l2, l2 + len1 - 1 );
        root.right = reConstruct(pre, len1 +l1 + 1, r1, in , index +1, r2);
        return root;
    }
    
    
    public int getIndex(int[] in, int l, int r, int target){
        if(in == null || in.length == 0 || l > r){
            return -1;
        }
        for(int i = l; i <= r; i++){
            if(in[i] == target){
                return i;
            }
        }
        return -1;
    }
}
}
