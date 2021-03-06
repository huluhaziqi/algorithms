package com.huluhaziqi.algorithms.algorithms.binary_search;

public class LeetCode278 {

    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    /**
     * 278. First Bad Version
     * Easy
     * <p>
     * 971
     * <p>
     * 553
     * <p>
     * Add to List
     * <p>
     * Share
     * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
     * <p>
     * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
     * <p>
     * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
     * <p>
     * Example:
     * <p>
     * Given n = 5, and version = 4 is the first bad version.
     * <p>
     * call isBadVersion(3) -> false
     * call isBadVersion(5) -> true
     * call isBadVersion(4) -> true
     * <p>
     * Then 4 is the first bad version.
     */
    public class Solution {
        public int firstBadVersion(int n) {
            if (n <= 0) {
                return -1;
            }
            int l = 1;
            int h = n;
            while (l < h) {
                int mid = l + (h - l) / 2;
                if (isBadVersion(mid)) {
                    h = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }
    }

    boolean isBadVersion(int version) {
        return false;
    }
}
