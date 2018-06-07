package lin.java.test.algorithms.dynamic_programming;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {2};
        int S = 2;
        int result = new TargetSum().findTargetSumWays(nums, S);
        System.out.println(result);
    }

    int[] f = {1, -1};

    public int findTargetSumWays2(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        dfs(nums, 0, 0, S);
        return result;
    }
    int result = 0;
    void dfs(int[] nums, int level, int value, int S) {
        if (level == nums.length && value == S) {
            result++;
            return;
        }
        if (level >= nums.length) {
            return;
        }
        for(int d : f){
            dfs(nums,level + 1,d * nums[level] + value,S);
        }
    }

    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // (target + sum) / 2 = x;
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = (S + sum) / 2;
        if (target % 2 == 1) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int j = target; j >= 0; j--) {
                if (j >= n) {
                    dp[j] = dp[j] + dp[j - n];
                }
            }
        }
        return dp[target];
    }

    class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            return dfs(nums,S,0);
        }
        int dfs(int[] nums,int s,int level){
            if(level == nums.length) return s == 0 ? 1 : 0;
            return dfs(nums,s - nums[level],level + 1) + dfs(nums,s + nums[level],level + 1);
        }
    }

    class Solution2 {
        public int findTargetSumWays(int[] nums, int S) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            int sum = 0;
            for(int num : nums){
                sum += num;
            }
            int target = (sum - S) / 2;
            if(sum < S || (sum - S) % 2 == 1){
                return 0;
            }
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for(int num : nums){
                for(int j = target; j >= 0; j--){
                    if(j >= num){
                        dp[j] += dp[j - num];
                    }
                }
            }
            return dp[target];
        }
    }
}
