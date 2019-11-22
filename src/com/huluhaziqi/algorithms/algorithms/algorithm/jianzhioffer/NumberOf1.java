package com.huluhaziqi.algorithms.algorithms.algorithm.jianzhioffer;

public class NumberOf1 {
    public static void main(String[] args) {
        int n = -128;
        int result = function(n);
    }

    public static int function(int n) {
        int result = 0;
        while(n != 0){
            if((n & 1) == 1){
                result++;
            }
            n >>>= 1;
        }
        return result;
    }
}
