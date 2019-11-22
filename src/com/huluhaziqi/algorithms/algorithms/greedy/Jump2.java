package com.huluhaziqi.algorithms.algorithms.greedy;

public class Jump2 {
    public static void main(String[] args) {
        int nums[] = {2,3,1,1,4};
        int result = new Jump2().jump(nums);
        System.out.println(result);
    }

    public int jump(int[] nums) {
        if(nums == null || nums.length ==0 ){
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = 0;
        int i = max;
        while(i < nums.length){
            int tem = nums[i] + i;
            for(int j = 1; j <= nums[i];j++){
                if(i + j < nums.length){
                    if(dp[i + j] != 0) {
                        dp[i + j] = Math.min(dp[i + j], dp[nums[i]] + 1);
                    }else{
                        dp[i + j] =1;
                    }
                    if(nums[i + j] + i + j > max){
                        max = nums[i + j] + i + j;
                        if(max >= nums.length - 1){
                            return dp[nums.length - 1];
                        }
                    }
                }
            }
            i = max;
        }
        return dp[nums.length - 1];

    }
}
