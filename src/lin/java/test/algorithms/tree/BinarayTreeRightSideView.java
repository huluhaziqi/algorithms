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
}
