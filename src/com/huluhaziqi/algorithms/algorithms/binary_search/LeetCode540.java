package com.huluhaziqi.algorithms.algorithms.binary_search;

public class LeetCode540 {

    class Solution {
        public int singleNonDuplicate(int[] nums) {
            if(nums == null || nums.length == 0){
                return -1;
            }
            int l = 0;
            int r = nums.length - 1;
            while(l < r){
                int m = l + (r - l) / 2;
                if((m % 2) == 1){
                    if(nums[m] == nums[m + 1]) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                } else {
                    if(nums[m] == nums[m + 1]){
                        l = m + 2;
                    } else{
                        r = m;
                    }
                }
            }
            return nums[l];
        }
    }

    class Solution2 {
        public int singleNonDuplicate(int[] nums) {
            if(nums == null || nums.length == 0){
                return -1;
            }
            int l = 0;
            int r = nums.length - 1;
            while(l < r){
                int m = l + (r - l) / 2;
                if((m % 2) == 1){
                   m--;
                }
                if(nums[m] == nums[m + 1]){
                    l = m + 2;
                } else {
                    r = m;
                }
            }
            return nums[l];
        }
    }
}
