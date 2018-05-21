package lin.java.test.algorithms.dynamic_programming;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int S = 3;
        int result = new TargetSum().findTargetSumWays(nums, S);
        System.out.println(result);
    }

    int[] f = {1, -1};

    public int findTargetSumWays(int[] nums, int S) {
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
}
