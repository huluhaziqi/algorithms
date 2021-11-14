package com.huluhaziqi.algorithms.algorithms.tree;

public class LeetCode106 {

    class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if(postorder == null || inorder == null){
                return null;
            }
            return build(postorder, 0, postorder.length - 1, inorder, 0 , inorder.length -1 );
        }

        public TreeNode build(int[] p, int ps, int pe,  int[] i, int is,int ie){
            if(ps > pe || is > ie){
                return null;
            }
            int index = get(i, p[pe], is, ie);
            if(index == -1 ){
                return null;
            }
            int len = index - is;
            TreeNode left = build(p,ps, ps + len - 1, i, is, index - 1);
            TreeNode right = build(p, ps + len, pe - 1, i, index + 1, ie);
            TreeNode root = new TreeNode(p[pe]);
            root.left = left;
            root.right = right;
            return root;
        }

        public int get(int[] nums, int target, int is, int ie){
            for(int i = is; i<= ie; i++){
                if(target == nums[i]){
                    return i;
                }
            }
            return -1;
        }

    }
}
