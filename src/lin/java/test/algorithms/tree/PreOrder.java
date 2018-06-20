package lin.java.test.algorithms.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {

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
         * @return: Preorder in ArrayList which contains node values.
         */
        public List<Integer> preorderTraversal(TreeNode root) {
            // write your code here
            if(root == null){
                return new ArrayList<>();
            }
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> result = new ArrayList<>();
            TreeNode cur = root;
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode tem = stack.pop();
                if(tem != null){
                    result.add(tem.val);
                    stack.push(tem.right);
                    stack.push(tem.left);
                }
            }
            return result;
        }
    }
}
