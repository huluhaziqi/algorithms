package com.huluhaziqi.algorithms.algorithms.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        List<List<Integer>> result = new Solution().levelOrder(root);
        result.forEach(o->{
            o.forEach(l->{
                System.out.print(l + ' ');
            });
            System.out.println();
        });
    }
    public static class Solution {
        /**
         * @param root: A Tree
         * @return: Level order a list of lists of integer
         */
        public List<List<Integer>> levelOrder(TreeNode root) {
            // write your code here
            if(root == null){
                return new ArrayList<>();
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            List<List<Integer>> result = new ArrayList<>();
            while(!queue.isEmpty()){
                List<Integer> tem = new ArrayList<>();
                int size = queue.size();
                for(int i = 0; i < size;i++){
                    TreeNode top = queue.peek();
                    if(top != null){
                        tem.add(top.val);
                        queue.add(top.left);
                        queue.add(top.right);
                    }
                }
                result.add(tem);
            }
            return result;
        }
    }
}
