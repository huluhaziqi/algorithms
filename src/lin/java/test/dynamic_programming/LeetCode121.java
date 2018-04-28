package lin.java.test.dynamic_programming;

public class LeetCode121 {

    public static void main(String[] args) {
            int[] prices = {3,3,5,0,0,3,1,4};
            int result = maxProfitD(prices);
        System.out.println(result);
    }

    public static int sumSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int max = 0;
        int sum = 0;
        for (int i = 1; i < len; i++) {
            sum += nums[i] - nums[i - 1];
            sum = Math.max(sum, nums[i] - nums[i - 1]);
            max = Math.max(sum, max);
        }
        return max;
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int max = 0;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum += prices[i] - prices[i - 1];
            sum = Math.max(prices[i] - prices[i - 1], sum);
            max = Math.max(max, sum);
        }
        return max;
    }

    public static int maxProfit1(int[] prices,int start, int end) {
        if(prices == null || prices.length <= 1 || end - start <= 1){
            return 0;
        }
        int min_price = prices[start];
        int profile = prices[start + 1] - prices[start];
        for (int i = start + 2; i < end; i++) {
            //阶段性最小的结果
            min_price = Math.min(prices[i], min_price);
            profile = Math.max(profile, prices[i] - min_price);
        }
        if (profile < 0) {
            return 0;
        }
        return profile;
    }

    public static int maxProfitD(int[] prices) {
        if(prices == null || prices.length <= 1){
            return 0;
        }
        int result = 0;
        for(int i = 1;i < prices.length - 1;i++){
            result = Math.max(maxProfit1(prices,0,i + 1) + maxProfit1(prices,i,prices.length),result);
        }
        return result;
    }

    public static int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min_price = prices[0];
        int profile = prices[1] - prices[0];
        for (int i = 1; i < prices.length; i++) {
            min_price = Math.min(min_price, prices[i]);
            profile = Math.max(profile, prices[i] - min_price);
        }
        return profile;
    }
}
