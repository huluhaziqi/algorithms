package com.huluhaziqi.algorithms.algorithms.greedy;

public class LeetCode655 {

    class Solution {
        public boolean checkPossibility(int[] nums) {
            if (nums == null || nums.length <= 2) {
                return true;
            }
            int count = 0;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] >= nums[i - 1]) {
                    continue;
                }
                count++;
                if (i >= 2 && nums[i] < nums[i - 2]) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[i - 1] = nums[i];
                }
            }

            return count <= 1;
        }
    }
}
