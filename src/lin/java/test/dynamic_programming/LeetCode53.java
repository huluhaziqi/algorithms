package lin.java.test.dynamic_programming;

public class LeetCode53 {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        long start = System.currentTimeMillis();
        int result = sumSubArray1(nums);
        long end = System.currentTimeMillis();
        System.out.println(result);
        System.out.println(end - start);
        start = System.currentTimeMillis();
        int result2 = maxSubArray(nums);
        end = System.currentTimeMillis();
        System.out.println(result2);
        System.out.println(end - start);


    }

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
//        int cur = 0;
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], nums[i] + sum);
            max = Math.max(max,sum);
        }

        return max;
    }

    public static int sumSubArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j < len; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
