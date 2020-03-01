package com.huluhaziqi.algorithms.algorithms.binary_search;

public class Leetcode153 {

    /**
     * leetcode 153
     * 153. Find Minimum in Rotated Sorted Array
     * Medium
     * <p>
     * 1610
     * <p>
     * 210
     * <p>
     * Add to List
     * <p>
     * Share
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     * <p>
     * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
     * <p>
     * Find the minimum element.
     * <p>
     * You may assume no duplicate exists in the array.
     * <p>
     * Example 1:
     * <p>
     * Input: [3,4,5,1,2]
     * Output: 1
     * Example 2:
     * <p>
     * Input: [4,5,6,7,0,1,2]
     * Output: 0
     */
    class Solution {
        public int findMin(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int len = nums.length;
            int index = 0;
            int s = 0;
            int e = len - 1;
            while (s < e) {
                int mid = (e - s) / 2 + s;
                if (nums[mid] >= nums[len - 1]) {
                    s = mid + 1;
                } else {
                    e = mid;
                }
            }
            return nums[s];
        }
    }
}
