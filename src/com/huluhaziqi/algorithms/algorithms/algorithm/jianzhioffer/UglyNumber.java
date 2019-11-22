package com.huluhaziqi.algorithms.algorithms.algorithm.jianzhioffer;

public class UglyNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.GetUglyNumber_Solution(9);
        System.out.println(result);
    }

    public static class Solution {
        public int GetUglyNumber_Solution(int index) {
            if(index == 1){
                return 1;
            }
            int[] num = new int[index + 1];
            num[1] = 1;

            int index2 = 2;
            int index3 = 3;
            int index5 = 5;
            for(int i = 2; i <= index; i++){
                int tem = min(index2,index3,index5);
                if(tem == index2){
                    index2 = tem;
                }
                if(tem == index3){
                    index3 = tem;
                }
                if(tem == index5){
                    index5 = tem;
                }
                num[i] = tem;
            }
            for(int i = 0; i < num.length;i++){
                System.out.println("i = " + num[i]);
            }

                return num[index];
        }
        public int min(int a,int b,int c){
            return Math.min(Math.min(a,b),c);
        }
    }
}
