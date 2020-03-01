package com.huluhaziqi.algorithms.algorithms.binary_search;

import java.util.Arrays;

public class SearchForARange {

    /**
     * leetcode 34
     * 34. Find First and Last Position of Element in Sorted Array
     * Medium
     * <p>
     * 2631
     * <p>
     * 117
     * <p>
     * Add to List
     * <p>
     * Share
     * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
     * <p>
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * <p>
     * If the target is not found in the array, return [-1, -1].
     * <p>
     * Example 1:
     * <p>
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * Example 2:
     * <p>
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     * Accepted
     * 424,426
     * Submissions
     * 1,209,532
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {2, 2};
        int target = 2;
        int index = new SearchForARange().maxIndex(nums, target);
        System.out.println(index);
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.fill(result, -1);
        if (nums == null || nums.length == 0) {
            return result;
        }
        int l = minIndex(nums, target);
        int r = l;
        System.out.println("l " + l + " r " + r);
        if (l >= 0 && l < nums.length - 1 && nums[l] == target) {
            result[0] = l;
            while (r < nums.length && nums[r] == target) {
                r++;
            }
            result[1] = r;
        }
        return result;
    }

    public int minIndex(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public int maxIndex(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        return r;

    }

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }
            int start = binary_search(nums, target);
            int end = binary_search(nums, target + 1) - 1;
            if (start == nums.length || nums[start] != target) {
                return new int[]{-1, -1};
            } else {
                return new int[]{start, end};
            }
        }

        int binary_search(int nums[], int target) {
            int l = 0;
            int h = nums.length;
            while (l < h) {
                int mid = l + (h - l) / 2;
                if (nums[mid] >= target) {
                    h = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }
    }
}
