package lin.java.test.algorithms.algorithm.jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
public class PrintTreeNode {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution.TreeNode root = new Solution.TreeNode(1);
        root.left = new Solution.TreeNode(2);
        root.right = new Solution.TreeNode(3);
        root.left.left = new Solution.TreeNode(4);
        root.left.right = new Solution.TreeNode(5);
        root.right.left = new Solution.TreeNode(6);
        root.right.right = new Solution.TreeNode(7);
        ArrayList<ArrayList<Integer>> result = solution.Print(root);
        System.out.println(result);
    }

    public static class Solution {
        public static class TreeNode {
            int val = 0;
            TreeNode left = null;
            TreeNode right = null;

            public TreeNode(int val) {
                this.val = val;

            }
        }
        public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
            ArrayList<ArrayList<Integer> > result = new ArrayList<>();
            if(pRoot == null){
                return result;
            }
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(pRoot);
            int k = 0;
            while(!queue.isEmpty()){
                int size = queue.size();
                ArrayList<Integer> list = new ArrayList<>();
                for(int i = size -1 ; i >= 0; i--){
                    if(k % 2 == 0){
                        list.add(queue.get(i).val);
                    }else{
                        list.add(queue.get(size - 1 - i).val);
                    }
                }
                for(int i = 0; i < size; i++){
                    TreeNode top = queue.remove();
                    //list.add(top.val);
                    if(top.right != null){
                        queue.add(top.right);
                    }
                    if(top.left != null){
                        queue.add(top.left);
                    }
                }
                result.add(list);
                k++;
            }
            return result;
        }

    }
}
