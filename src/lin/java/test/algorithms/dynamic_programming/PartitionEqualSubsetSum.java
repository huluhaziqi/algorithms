package lin.java.test.algorithms.dynamic_programming;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        boolean result = new PartitionEqualSubsetSum().canPartition(nums);
        System.out.println(result);
    }
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int sum = 0;
        int len = nums.length;
        for(int i = 0; i < len; i++){
            sum += nums[i];
        }
        if(sum % 2 == 1){
            return false;
        }
        boolean[][] dp = new boolean[len + 1][sum + 1];
        for(int i = 0; i < len; i++){
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for(int i = 1; i < len; i++){
            int tem = nums[i];
            for(int j = 0; j <= sum / 2; j++){
                if(j >= tem)
                    dp[i][j] = dp[i - 1][j]|| dp[i - 1][j - tem];
            }
        }
        return dp[len - 1][sum / 2];
    }
}