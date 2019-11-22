package com.huluhaziqi.algorithms.algorithms.algorithm.jianzhioffer;

public class FindNumberAppearOnce {

    public static void main(String[] args) {

    }

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public class Solution {
        public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
            if (array == null || array.length == 0) {
                return;
            }
            int len = array.length;
            int result = array[0];
            for (int i = 1; i < len; i++) {
                result ^= array[i];
            }
            int index = findFirstBit1(result);
            for (int i = 0; i < array.length; i++) {
                if (judgeBit1(array[i], index)) {
                    num1[0] ^= array[i];
                } else {
                    num2[0] ^= array[i];
                }
            }
        }

        public int findFirstBit1(int n) {
            int result = 0;
            while ((n & 1) == 0) {
                n >>= 1;
                result++;
            }
            return result;
        }

        public boolean judgeBit1(int num, int index) {
            num >>= index;
            return (num & 1) == 1 ? true : false;
        }
    }
}
