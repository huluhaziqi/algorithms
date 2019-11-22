package com.huluhaziqi.algorithms.algorithms.algorithm.jianzhioffer;

public class FindInArray {

    public class Solution {
        public boolean Find(int target, int [][] array) {
            if(array == null || array.length == 0){
                return false;
            }
            return search(target,array);
        }

        public boolean search(int target,int[][] array){
            if(array == null || array.length == 0){
                return false;
            }
            int row = array.length;
            int col = array[0].length;
            int i = col - 1;
            int j = 0;
            while(i >= 0 && j < row){
                if(array[j][i] == target){
                    return true;
                } else if(array[j][i] > target){
                    i--;
                } else {
                    j++;
                }
            }
            return false;
        }

    }
}
