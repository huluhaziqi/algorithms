package lin.java.test.algorithms.dynamic_programming;

public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {
        int[] prices = {1, 3, 1};
        int result = new BestTimetoBuyandSellStock().rob(prices);
        System.out.println(result);
    }

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] local = new int[nums.length];
        int n = nums.length;
        local[0] = nums[0];
        local[1] = nums[1];
        local[2] = nums[0] + nums[2];
        for (int i = 3; i < nums.length; i++) {
            local[i] = Math.max(local[i - 3] + nums[i], local[i - 2] + nums[i]);
        }
        return Math.max(local[n - 1], local[n - 2]);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int pre = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int tem = max;
            max = Math.max(pre + nums[i], max);
            pre = tem;
        }

        return max;
    }
}
