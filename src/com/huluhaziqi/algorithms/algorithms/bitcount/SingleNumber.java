package com.huluhaziqi.algorithms.algorithms.bitcount;

public class SingleNumber {

    public static void main(String[] args) {

    }

    class Solution {
        public int singleNumber(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            int ret = 0;
            for(int i : nums){
                ret ^= i;
            }
            return ret;
        }
    }
}
