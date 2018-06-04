package lin.java.test.algorithms.fs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindModeInBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    class Solution {
        public int[] findMode(TreeNode root) {
            if(root == null){
                return new int[0];
            }
            Map<Integer,Integer> map = new HashMap<>();
            travel(root,map);
            List<Integer> list = new ArrayList<>();
            for(Map.Entry entry : map.entrySet()){
                if((int)entry.getValue() == max){
                    list.add((int)entry.getKey());
                }
            }
            int[] result = new int[list.size()];
            int idex = 0;
            for(int i : list){
                result[idex] = i;
                idex++;
            }
            return result;
        }
        int max = Integer.MIN_VALUE;
        void travel(TreeNode root,Map<Integer,Integer> map){
            if(root == null){
                return;
            }
            if(map.containsKey(root.val)){
                map.put(root.val,map.get(root.val) + 1);
                max = Math.max(map.get(root.val),max);
            }else{
                map.put(root.val,1);
                max = Math.max(1,max);
            }
            travel(root.left,map);
            travel(root.right,map);
        }
    }
}
