package lin.java.test.algorithms.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberofArrowstoBurstBalloons {

    public static void main(String[] args) {
        int[][] points = {{1,2}, {2, 3}, {3, 4}};
        int result = new MinimumNumberofArrowstoBurstBalloons().findMinArrowShots3(points);
        System.out.println(result);
    }

    public int findMinArrowShots(int[][] points) {
        if (points == null | points.length <= 1 || points[0].length == 0) {
            return 0;
        }
        Arrays.sort(points, (o1, o2) -> o1[1] - o2[1]);
        int cnt = 1;
        int start = points[0][0];
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if(points[i][0] > end){
                cnt++;
                start = points[i][0];
                end = points[i][1];
            } else {
                start = Math.max(start,points[i][0]);
                end = Math.min(end,points[i][1]);
            }
        }
        return points.length - cnt;
    }

    public int findMinArrowShots2(int[][] points) {
        if (points == null | points.length <= 1 || points[0].length == 0) {
            return 0;
        }
        Arrays.sort(points, (o1, o2) -> o1[1] - o2[1]);
        int cnt = 1;
        int end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if(points[i][0] > end){
                cnt++;
                end = points[i][1];
            } else {
                end = Math.min(end,points[i][1]);
            }
        }
        return cnt;
    }

    public int findMinArrowShots3(int[][] points) {
        if (points.length == 0)
            return 0;

        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        int cnt = 1, end = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int tem = points[i][0];
            if (tem <= end) // [1,2] 和 [2,3] 算重叠
                continue;
            cnt++;
            end = points[i][1];
        }
        return cnt;
    }
}
