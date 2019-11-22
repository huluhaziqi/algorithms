package com.huluhaziqi.algorithms.algorithms.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSuquence {

    public static void main(String[] args) {

    }

    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        if (nums.length == 1) {
            return 1;
        }
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= list.get(0)) {
                list.set(0, nums[i]);
            }
            if(nums[i] > list.get(list.size() - 1)){
                list.add(nums[i]);
            }
            int tem = binarySearch(list, nums[i]);
            list.set(tem, nums[i]);
        }
        return list.size();
    }

    int binarySearch(List<Integer> list, int target) {
        int start = 0;
        int end = list.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
