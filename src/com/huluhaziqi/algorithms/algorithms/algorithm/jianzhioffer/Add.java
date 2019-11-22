package com.huluhaziqi.algorithms.algorithms.algorithm.jianzhioffer;

public class Add {

    public static void main(String[] args) {

    }

    public class Solution {
        public int Add(int num1, int num2) {
            int sum = 0;
            int c = 0;
            do {
                sum = num1 ^ num2;
                c = num1 & num2;
                num1 = sum;
                num2 = c;
            } while (num2 != 0);
            return num1;
        }
    }

}
