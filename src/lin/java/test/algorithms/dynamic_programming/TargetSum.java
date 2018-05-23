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
        int ret = 0;
        ret = dfs(nums, 0, 0, S);
        return ret;
    }

    int dfs(int[] nums, int level, int value, int S) {
        if (level == nums.length && value == S) {
            return 1;
        }
        if (level >= nums.length) {
            return 0;
        }
        int result = 0;
        for (int j : f) {
            result += dfs(nums, level + 1, value + j * nums[level], S);
        }
        return result;
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
}
