package com.huluhaziqi.algorithms.algorithms.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NonOverlaping {

    public static void main(String[] args) {
        Interval[] intervals = new Interval[4];
        intervals[0] = new Interval(1, 2);
        intervals[1] = new Interval(2, 3);
        intervals[2] = new Interval(3, 4);
        intervals[3] = new Interval(1, 3);
        int result = new NonOverlaping().eraseOverlapIntervals(intervals);
        System.out.println(result);
    }

    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o->o.end));
        int base = intervals[0].start;
        int maxIndex = intervals[intervals.length - 1].start;
        List<List<Interval>> list = new ArrayList<>();
        for (int i = 0; i < maxIndex + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (Interval interval : intervals) {
            int start = interval.start;
            list.get(start).add(interval);
        }
        int result = 0;
        int preMax = 0;
        for (int i = 0; i < list.size(); i++) {
            List<Interval> tem = list.get(i);
            int size = list.get(i).size();
            if (size != 0) {
                result += size - 1;
                int first = tem.get(0).start;
                int max = 0;
                for (int j = 0; j < size; j++) {
                    if (tem.get(j).end > max) {
                        max = tem.get(j).end;
                    }
                }
                if (preMax > first) {
                    result++;
                }
                if (max > preMax) {
                    preMax = max;
                }
            }
        }
        return result;
    }

    public static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
