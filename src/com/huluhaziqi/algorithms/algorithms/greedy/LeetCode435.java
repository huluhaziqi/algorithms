package com.huluhaziqi.algorithms.algorithms.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode435 {

    /**
     * 435. Non-overlapping Intervals
     * Medium
     *
     *
     * Favorite
     *
     * Share
     * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
     *
     *
     *
     * Example 1:
     *
     * Input: [[1,2],[2,3],[3,4],[1,3]]
     * Output: 1
     * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
     * Example 2:
     *
     * Input: [[1,2],[1,2],[1,2]]
     * Output: 2
     * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
     * Example 3:
     *
     * Input: [[1,2],[2,3]]
     * Output: 0
     * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
     *
     *
     * Note:
     *
     * You may assume the interval's end point is always bigger than its start point.
     * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
     */
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if(intervals == null || intervals.length == 0){
                return 0;
            }
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
            Arrays.sort(intervals, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[1] - b[1];
                }
            });
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });
            // int start = intervals[0][0];
            int end = intervals[0][1];
            int count = 1;
            for(int i = 1; i < intervals.length; i++){
                if(intervals[i][0] < end){
                    continue;
                }
                count++;
                // start = intervals[i][0];
                end = intervals[i][1];
            }
            return intervals.length - count;
        }
    }
}
