package com.huluhaziqi.algorithms.algorithms.greedy;

public class LeetCode53 {

    /**
     * 53. Maximum Subarray
     * Easy
     * Share
     * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
     * <p>
     * Example:
     * <p>
     * Input: [-2,1,-3,4,-1,2,1,-5,4],
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     * Follow up:
     * <p>
     * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
     */
    class Solution {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int max = nums[0];
            int tem = nums[0];
            for (int i = 1; i < nums.length; i++) {
                tem = tem + nums[i] < nums[i] ? nums[i] : tem + nums[i];
                max = Math.max(tem, max);
            }
            return max;
        }
    }

    class Solution2 {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            long max = Integer.MIN_VALUE;
            long tem = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                tem = tem + nums[i] < nums[i] ? nums[i] : tem + nums[i];
                max = Math.max(tem, max);
            }
            return (int) max;
        }
    }

    class Solution3 {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int global = nums[0];
            int local = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (local < 0) {
                    local = nums[i];
                } else {
                    local += nums[i];
                }
                global = Math.max(local, global);
            }
            return global;

        }
    }
}
