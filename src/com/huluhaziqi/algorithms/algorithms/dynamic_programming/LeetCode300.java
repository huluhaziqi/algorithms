package com.huluhaziqi.algorithms.algorithms.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class LeetCode300 {

    public static void main(String[] args) {
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = {10, 9, 2, 5, 3, 4};
        int result = new LeetCode300().lengthOfLIS6(nums);
        System.out.println(result);
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return 1;
        }
        int[] local = new int[len];
        int global = 1;
        local[0] = 1;
        for (int i = 1; i < len; i++) {
            local[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    local[i] = Math.max(local[j] + 1, local[i]);
                }
                global = Math.max(global, local[i]);
            }
        }
        return global;
    }

    public int lengthOfLIS5(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
                if (dp[i] > max) {
                    max = dp[i];
                }
            }
        }
        return max;
    }

    public static int lengthOfLIS3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 0;
        int[] tail = new int[nums.length];
        tail[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < tail[0]) {
                tail[0] = nums[i];
            }
            if (nums[i] > tail[len]) {
                tail[++len] = nums[i];
            } else {
                tail[binarySearch(tail, 0, len, nums[i])] = nums[i];
            }
        }
        return len + 1;
    }

    public static int binarySearch(int[] tail, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (tail[mid] == target) {
                return mid;
            }
            if (tail[mid] > target) {
                end = mid - 1;
            }
            if (tail[mid] < target) {
                start = mid + 1;
            }
        }
        return start;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return 1;
        }
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < len; i++) {
            if (nums[i] < list.get(0)) {
                list.set(0, nums[i]);
            } else if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                list.set(binarySearch(list, 0, list.size(), nums[i]), nums[i]);
            }
        }
        return list.size();
    }

    public int binarySearch(List<Integer> list, int start, int end, int x) {
        if (start > end) {
            return -1;
        }
        while (start <= end) {
            int mid = (start + end) / 2;
            int tem = list.get(mid);
            if (tem == x) {
                return mid;
            } else if (tem > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    public int lengthOfLIS6(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 1;
        int[] tem = new int[nums.length];
        tem[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (tem[len - 1] < nums[i]) {
                tem[len++] = nums[i];
            } else {
                int index = binarySearch6(tem, 0, len, nums[i]);
                tem[index] = nums[i];
            }
        }
        return len;
    }

    public int binarySearch6(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return start;
    }
}
