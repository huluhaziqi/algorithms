package com.huluhaziqi.algorithms.algorithms.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode452 {

    /**
     * 452. Minimum Number of Arrows to Burst Balloons
     * Medium
     * <p>
     * Share
     * There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.
     * <p>
     * An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.
     * <p>
     * Example:
     * <p>
     * Input:
     * [[10,16], [2,8], [1,6], [7,12]]
     * <p>
     * Output:
     * 2
     * <p>
     * Explanation:
     * One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
     */
    class Solution {
        public int findMinArrowShots(int[][] points) {
            if (points == null || points.length == 0) {
                return 0;
            }
            Arrays.sort(points, new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });
            int count = 1;
            int end = points[0][1];
            for (int i = 1; i < points.length; i++) {
                if (points[i][0] <= end) {
                    continue;
                } else {
                    end = points[i][1];
                    count++;
                }
            }
            return count;
        }
    }

    class Solution2 {
        public int findMinArrowShots(int[][] point) {
            if (point == null || point.length == 0 || point[0] == null
                    || point[0].length == 0) {
                return 0;
            }
            int row = point.length;
            int col = point[0].length;
            Arrays.sort(point, Comparator.comparingInt(o -> o[1]));
            int preEnd = point[0][1];
            int count = 1;
            for (int i = 1; i < row; i++) {
                if (point[i][0] > preEnd) {
                    preEnd = point[i][1];
                    count++;
                } else {
                    continue;
                }
            }
            return count;
        }
    }
}
