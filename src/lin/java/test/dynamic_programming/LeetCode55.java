package lin.java.test.dynamic_programming;

import java.util.Arrays;

public class LeetCode55 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 1, 4};
        boolean result = new LeetCode55().canJump(nums);
        System.out.println(result);
    }

    /**
     * 超时，N^2
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        boolean[] dp = new boolean[nums.length];
        Arrays.fill(dp, false);
        dp[0] = nums[0] > 0 ? true : false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[i] == true) break;
                if (dp[j] == true) {
                    dp[i] |= (j + nums[j] >= i) ? true : false;
                }
            }
        }
        return dp[nums.length - 1];
    }

    public boolean canJump1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        boolean[] dp = new boolean[nums.length];
        Arrays.fill(dp, false);
        dp[0] = nums[0] > 0 ? true : false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[i] == true) break;
                if (dp[j] == true) {
                    dp[i] |= (j + nums[j] >= i) ? true : false;
                }
            }
        }
        return dp[nums.length - 1];
    }

    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int index = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= index) {
                index = i;
            }
        }
        return index == 0;
    }

    public boolean canJump3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int maxLen = nums[0];
        for (int i = 0; i <= maxLen; i++) {
            maxLen = Math.max(maxLen, nums[i] + i);
        }
        return maxLen >= nums.length ? true : false;
    }
}
