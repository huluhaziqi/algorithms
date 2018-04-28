package lin.java.test.dynamic_programming;

public class LeetCode198 {

    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            int[] global = new int[nums.length + 1];
            int local;

            local = nums[0];
            global[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (i == 1) {
                    local = nums[1];
                }
                if (i >= 2) {
                    local = global[i - 2] + nums[i];
                }
                global[i] = Math.max(global[i - 1], local);
            }
            return global[nums.length - 1];
        }
    }

    public int rob2(int[] nums) {
        int[] max;
        if (nums.length == 0) return 0;
        max = new int[nums.length];
        if (nums.length == 1) return nums[0];
        max[nums.length - 1] = nums[nums.length - 1];
        max[nums.length - 2] = Math.max(nums[nums.length - 1], nums[nums.length - 2]);
        for (int i = nums.length - 3; i >= 0; i--) {
            max[i] = Math.max(max[i + 1], nums[i] + max[i + 2]);
        }
        return max[0];
    }

    public int rob3(int[] nums) {
        if (nums.length == 0) return 0;
        int pre = 0;
        int curr = 0;
        for (int n : nums) {
            int tem = curr;
            curr = Math.max(curr, pre + n);
            pre = tem;
        }
        return curr;
    }

}