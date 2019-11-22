package com.huluhaziqi.algorithms.algorithms.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {

    /**
     * Definition of TreeNode:
     * public class TreeNode {
     *     public int val;
     *     public TreeNode left, right;
     *     public TreeNode(int val) {
     *         this.val = val;
     *         this.left = this.right = null;
     *     }
     * }
     */

    public class Solution {
        /**
         * @param root: A Tree
         * @return: Inorder in ArrayList which contains node values.
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            // write your code here
            if(root == null){
                return new ArrayList<>();
            }
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> list = new ArrayList<>();
            TreeNode cur = root;
            while(cur != null || !stack.isEmpty()){
                while(cur != null){
                    stack.push(cur);
                    cur = cur.left;
                }
                TreeNode top = stack.pop();
                if(top != null){
                    list.add(top.val);
                    cur = top.right;
                }
            }
            return list;
        }
    }
}
