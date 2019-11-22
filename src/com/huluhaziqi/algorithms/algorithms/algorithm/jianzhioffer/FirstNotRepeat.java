package com.huluhaziqi.algorithms.algorithms.algorithm.jianzhioffer;

public class FirstNotRepeat {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.FirstNotRepeatingChar("google");
    }
    public static class Solution {
        public int FirstNotRepeatingChar(String str) {
            if(str == null || str.length() == 0){
                return -1;
            }
            int[] num = new int[57];
            for(int i = 0; i < str.length();i++){
                char c = str.charAt(i);
                int index = c - 'A';
                if(num[index] == -1){
                    continue;
                }
                if(num[index] > 0){
                    num[index] = -1;
                }
                if(num[index] == 0){
                    num[index] = i + 1;
                }
            }
            int result = Integer.MAX_VALUE;
            for(int i = 0; i < num.length; i++){
                if(num[i] > 0){
                    if(num[i] < result){
                        result = num[i];
                    }
                }
            }
            return result == Integer.MAX_VALUE ? -1 : result - 1;
        }
    }
}
