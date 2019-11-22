package com.huluhaziqi.algorithms.algorithms.algorithm.jianzhioffer;

import java.util.ArrayList;

public class FindNumberWithSum2 {

    public static void main(String[] args) {

    }

    public static class Solution {
        public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
            ArrayList<Integer> result = new ArrayList<>();
            if(array == null || array.length <= 1){
                return result;
            }
            int l = 0;
            int r = array.length - 1;
            int m = Integer.MAX_VALUE;
            while(l < r){
                int tem = array[l] + array[r];
                int mult = array[l] * array[r];
                if(tem == sum){
                    if(mult < m){
                        m = mult;
                        result.clear();
                        result.add(Math.min(array[l],array[r]));
                        result.add(Math.max(array[l],array[r]));
                    }
                    l++;
                    r--;
                }else if ( tem > sum){
                    r--;
                }else{
                    l++;
                }
            }
            return result;
        }
    }
}
