package com.huluhaziqi.algorithms.algorithms.tree;

public class ConvertSortedArrayToBST {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if(nums == null || nums.length == 0){
                return null;
            }
            return build(nums,0,nums.length - 1);
        }

        public TreeNode build(int[] nums,int s,int e){
            if(s > e){
                return null;
            }
            if(s == e){
                return new TreeNode(nums[s]);
            }
            int m = (s + e) / 2;
            TreeNode root = new TreeNode(nums[m]);
            root.left = build(nums,s,m - 1);
            root.right = build(nums,m + 1, e);
            return root;
        }
    }
}
