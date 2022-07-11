package com.huluhaziqi.algorithms.algorithms.greedy;

import java.util.*;

public class LeetCode56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            List<int[]> list = new ArrayList<>();
            if(intervals == null){
                return new int[0][0];
            }
            Arrays.sort(intervals,Comparator.comparingInt(o->o[0]));
            for(int i = 0; i < intervals.length; i++){
                int l = intervals[i][0];
                int r = intervals[i][1];
                if(list.size() == 0 || list.get(list.size() - 1)[1] < l){
                    list.add(new int[]{l,r});
                } else {
                    list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], intervals[i][1]);
                }
            }
            return list.toArray(new int[list.size()][]);
        }
    }
}
