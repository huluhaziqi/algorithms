package lin.java.test.algorithms.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinarayTreeRightSideView {

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            if(root == null){
                return new ArrayList<>();
            }
            List<Integer> list = new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size;i++){
                    TreeNode f = queue.removeFirst();
                    if(f.left != null){
                        queue.add(f.left);
                    }
                    if(f.right != null){
                        queue.add(f.right);
                    }
                    if(i == size - 1){
                        list.add(f.val);
                    }
                }
            }
            return list;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(8);
        root.right.left.left = new TreeNode(7);
        root.right.left.left.right = new TreeNode(10);
        root.right.left.left.left = new TreeNode(7);

        List<Integer> list = new BinarayTreeRightSideView().rightSideView(root);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        getRightView(root, 0, result);
        return result;
    }

    public void getRightView(TreeNode root, int currentDepth, List<Integer> result){
        if(root==null)
            return;
        if(currentDepth == result.size()){
            result.add(root.val);
        }
        getRightView(root.right, currentDepth + 1, result);
        getRightView(root.left, currentDepth + 1, result);
    }
}
