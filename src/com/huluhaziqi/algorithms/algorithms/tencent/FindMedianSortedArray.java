package com.huluhaziqi.algorithms.algorithms.tencent;

public class FindMedianSortedArray {
    /**
     * 4. 寻找两个有序数组的中位数
     * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
     * <p>
     * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * <p>
     * 你可以假设 nums1 和 nums2 不会同时为空。
     * <p>
     * 示例 1:
     * <p>
     * nums1 = [1, 3]
     * nums2 = [2]
     * <p>
     * 则中位数是 2.0
     * 示例 2:
     * <p>
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * <p>
     * 则中位数是 (2 + 3)/2 = 2.5
     * 通过次数145,834提交次数395,449
     */
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if (nums1 == null && nums2 == null) {
                return 0.0;
            }
            int len1 = nums1.length;
            int len2 = nums2.length;

            int f1 = (len1 + len2 + 1) / 2;
            int f2 = (len1 + len2 + 2) / 2;
            return (getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, f1) + getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, f2)) * 1.0 / 2;
        }

        private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
            int len1 = end1 - start1 + 1;
            int len2 = end2 - start2 + 1;
            if (len1 > len2) {
                return getKth(nums2, start2, end2, nums1, start1, end1, k);
            }
            if (len1 == 0) {
                return nums2[start2 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[start1], nums2[start2]);
            }
            int i = start1 + Math.min(len1, (k / 2)) - 1;
            int j = start2 + Math.min(len2, (k / 2)) - 1;
            if (nums1[i] >= nums2[j]) {
                return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
            } else {
                return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
            }
        }
    }
}