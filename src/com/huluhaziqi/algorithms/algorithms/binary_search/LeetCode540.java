package com.huluhaziqi.algorithms.algorithms.binary_search;

public class LeetCode540 {


    /**
     * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
     *
     * 示例 1:
     *
     * 输入: [1,1,2,3,3,4,4,8,8]
     * 输出: 2
     * 示例 2:
     *
     * 输入: [3,3,7,7,10,11,11]
     * 输出: 10
     * 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行。
     *
     */
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                int m = l + (r - l) / 2;
                if ((m % 2) == 1) {
                    if (nums[m] == nums[m + 1]) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                } else {
                    if (nums[m] == nums[m + 1]) {
                        l = m + 2;
                    } else {
                        r = m;
                    }
                }
            }
            return nums[l];
        }
    }

    class Solution2 {
        public int singleNonDuplicate(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                int m = l + (r - l) / 2;
                if ((m % 2) == 1) {
                    m--;
                }
                if (nums[m] == nums[m + 1]) {
                    l = m + 2;
                } else {
                    r = m;
                }
            }
            return nums[l];
        }
    }
}
