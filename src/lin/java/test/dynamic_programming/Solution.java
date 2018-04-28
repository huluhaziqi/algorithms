package lin.java.test.dynamic_programming;

class Solution {

    public static void main(String[] args) {
        int[] nums = {10,9,8,1,2,5,3};
        System.out.println(lengthOfLIS1(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = getDp(nums);
        int max = Integer.MIN_VALUE;
        for (int i = dp.length - 1; i >= 0; i--) {
            max = Math.max(dp[i], max);
        }
        generathOfLIS(nums, dp);
        return max;
    }

    public static int[] getDp(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp;
    }

    public static int generathOfLIS(int[] nums, int[] dp) {
        int len = 0;
        int index = 0;
        for (int i = dp.length - 1; i >= 0; i--) {
            if (len < dp[i]) {
                len = dp[i];
                index = i;
            }
        }
        int[] list = new int[len];
        list[--len] = nums[index];
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] < nums[index] && dp[i] == dp[index] - 1) {
                list[--len] = nums[i];
                index = i;
            }
        }
        System.out.println();
        for (int i : list) {
            System.out.print(i + " ");
        }
        return 0;
    }

    public static int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 0;
        int[] tail = new int[nums.length];
        for(int i = 1; i <nums.length; i++){
            if(nums[i] < tail[0]){
                tail[0] = nums[i];
            }
            if(nums[i] >= tail[len]){
                tail[++len] = nums[i];
            } else {
                tail[binarySearch(tail,0,len,nums[i])] = nums[i];
            }
        }
        return len + 1;
    }
    public static int binarySearch(int[] tail ,int start,int end ,int target){
        while (start <= end){
            int mid = (start + end) /2 ;
            if(tail[mid] == target){
                return mid;
            }
            if(tail[mid] > target){
                end = mid -1;
            }
            if(tail[mid] < target){
                start = mid + 1;
            }
        }
        return start;
    }


}