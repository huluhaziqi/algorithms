package com.huluhaziqi.algorithms.algorithms.tree;

public class Leetcode108 {

    /**
     * 108. Convert Sorted Array to Binary Search Tree
     * Easy
     *
     * 1874
     *
     * 184
     *
     * Add to List
     *
     * Share
     * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     *
     * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     *
     * Example:
     *
     * Given the sorted array: [-10,-3,0,5,9],
     *
     * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     * Accepted
     * 354,742
     * Submissions
     * 640,521
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            return build(nums, nums.length / 2, 0, nums.length - 1);
        }

        TreeNode build(int[] nums, int k, int s, int e) {
            if (s > e || k < s || k > e) {
                return null;
            }
            TreeNode root = new TreeNode(nums[k]);
            root.left = build(nums, s + (k - 1 - s) / 2, s, k - 1);
            root.right = build(nums, k + 1 + (e - k - 1) / 2, k + 1, e);
            return root;
        }
    }
}
