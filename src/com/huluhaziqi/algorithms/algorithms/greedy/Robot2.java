package com.huluhaziqi.algorithms.algorithms.greedy;

public class Robot2 {

    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(f(nums, 0, nums.length - 2), f(nums,1, nums.length - 1));
    }

    public int f(int[] nums, int start, int end) {
        if (nums == null || nums.length == 0 || start > end) {
            return 0;
        }

        if (start == end) {
            return nums[start];
        }
        if (start == end - 1) {
            return Math.max(nums[start], nums[end]);
        }
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = nums[start + 1];
        dp[start + 2] = Math.max(dp[start + 1], dp[start] + nums[start + 2]);
        for (int i = start + 3; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
        }
        return Math.max(dp[end], dp[end - 1]);
    }
}
