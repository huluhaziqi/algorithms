package com.huluhaziqi.algorithms.algorithms.algorithm.jianzhioffer;

public class ReverseSetence {

    public static void main(String[] args) {
        String str = " ";
        Solution solution = new Solution();
        System.out.println(solution.ReverseSentence(str));

    }
    public static class Solution {
        public String ReverseSentence(String str) {
            if(str == null || str.length() == 0){
                return "";
            }
            if(str.equals(" ")){
                return "\\ ";
            }
            String[] strs = str.split(" ");
            StringBuilder sb = new StringBuilder();
            for(int i = strs.length - 1; i >= 0; i--){
                if(i != 0){
                    sb.append(strs[i] + " ");
                }else{
                    sb.append(strs[i]);
                }
            }
            return sb.toString();
        }
    }
}
