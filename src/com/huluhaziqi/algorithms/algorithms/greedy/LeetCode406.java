package com.huluhaziqi.algorithms.algorithms.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode406 {

    static class Solution {
        public int[][] reconstructQueue(int[][] people) {
            if(people == null || people.length == 0){
                return new int[0][0];
            }
            int[][] result = new int[people.length][people[0].length];
            Arrays.sort(people, (a, b) ->  a[0] == b[0] ? a[1]  - b[1] : b[0] - a[0]);
            List<int[]> queue = new ArrayList<>();
            for(int[] p :people){
                queue.add(p[1], p);
            }
            return queue.toArray(new int[queue.size()][]);
        }
    }

    static class Solution2 {
        public int[][] reconstructQueue(int[][] people) {
            if(people == null ||people.length == 0){
                return new int[0][0];
            }
            int result[][] = new int[people.length][people[0].length];
            Arrays.sort(people, (o1, o2) -> {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o2[0] - o1[0];
            });

            for(int i = 1; i < people.length; i++){
                int s = people[i][0];
                int e = people[i][1];
                int j = i;
                for(j = i; j > e; j--){
                    people[j][0] = people[j - 1][0];
                    people[j][1] = people[j - 1][1];
                }
                people[j][0] = s;
                people[j][1] = e;

            }
            return people;
        }
    }

    public static void main(String[] args) {
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] result = new Solution().reconstructQueue(people);
        for(int[] i : result){
            for(int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
