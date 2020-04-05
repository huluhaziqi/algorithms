package com.huluhaziqi.algorithms.algorithms.greedy;

public class LeetCode494 {

    /**
     * class Solution {
     *     public int findTargetSumWays(int[] nums, int S) {
     *             if(nums == null || nums.length == 0){
     *                 return 0;
     *             }
     *             backtracing(nums,S,0,0);
     *             return count;
     *     }
     *
     *     int[] dir = {-1, 1};
     *     int count = 0;
     *     void backtracing(int[] nums, int s, int index, int sum){
     *         if(index > nums.length){
     *             return;
     *         }
     *         if(index == nums.length){
     *             if(sum == s){
     *                 count++;
     *             }
     *             return;
     *         }
     *         for(int i : dir){
     *             int tem = i * nums[index];
     *             sum += tem;
     *             backtracing(nums,s,index +1,sum);
     *             sum -= tem;
     *         }
     *     }
     * }
     */
    /**
     * backtracing 方法
     */
    class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            backtracing(nums, S, 0, 0);
            return count;
        }

        int[] dir = {-1, 1};
        int count = 0;

        void backtracing(int[] nums, int s, int index, int sum) {
            if (index > nums.length) {
                return;
            }
            if (index == nums.length) {
                if (sum == s) {
                    count++;
                }
                return;
            }
            for (int i : dir) {
                int tem = i * nums[index];
                sum += tem;
                backtracing(nums, s, index + 1, sum);
                sum -= tem;
            }
        }
    }

    class Solution2 {
        public int findTargetSumWays(int[] nums, int S) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int sum = sum(nums);
            if (sum < S || (sum + S) % 2 != 0) {
                return 0;
            }
            int target = (sum + S) / 2;
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int n : nums) {
                for (int j = target; j >= n; j--) {
                    dp[j] = dp[j] + dp[j - n];
                }
            }
            return dp[target];
        }

        int sum(int[] nums) {
            int sum = 0;
            for (int n : nums) {
                sum += n;
            }
            return sum;
        }
    }
}
