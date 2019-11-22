package com.huluhaziqi.algorithms.algorithms.dynamic_programming;

public class MaximumProductSubarray {
    public static void main(String[] args) {
    }

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int max = nums[0];
        int[] dp = new int[len];
        int[] mm = new int[len];
        dp[0] = nums[0];
        mm[0] = nums[0];
        for (int i = 1; i < len; i++) {
            int temMax = Math.max(nums[i] * dp[i - 1], nums[i]);
            dp[i] = Math.max(temMax, nums[i] * mm[i - 1]);
            int temMin = Math.min(nums[i] * mm[i - 1], nums[i]);
            mm[i] = Math.min(nums[i] * dp[i - 1], temMin);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxProduct2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int maxLocal = nums[0];
        int minLocal = nums[0];
        int maxGlobal = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            int temMax = maxLocal, temMin = minLocal;
            maxLocal = Math.max(Math.max(nums[i] * temMax, nums[i]), nums[i] * temMin);
            minLocal = Math.min(nums[i] * temMax, Math.min(nums[i] * temMin, nums[i]));
            maxGlobal = Math.max(maxGlobal, maxLocal);
        }
        return maxGlobal;
    }
}
