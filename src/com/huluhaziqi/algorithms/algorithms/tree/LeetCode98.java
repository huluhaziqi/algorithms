package com.huluhaziqi.algorithms.algorithms.tree;

import java.util.Stack;

public class LeetCode98 {

    class Solution {
        public boolean isValidBST(TreeNode root) {
            if(root == null){
                return true;
            }
            long pre = -Integer.MAX_VALUE;
            Stack<TreeNode> stack = new Stack<>();

            TreeNode temp = root;
            while(!stack.isEmpty() ||temp != null){
                while(temp != null){
                    stack.push(temp);
                    temp = temp.left;
                }
                TreeNode top = stack.pop();
                if(top != null){
                    boolean res = top.val > pre;
                    if(!res){
                        return false;
                    }
                    pre = top.val;
                    temp = top.right;
                }
            }
            return true;
        }
    }
}
