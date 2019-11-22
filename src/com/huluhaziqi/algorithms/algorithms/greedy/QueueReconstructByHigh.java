package com.huluhaziqi.algorithms.algorithms.greedy;

import java.util.Arrays;

public class QueueReconstructByHigh {

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] result = new QueueReconstructByHigh().reconstructQueue(people);
        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return new int[0][0];
        }
        int len = people.length;
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o2[0] - o1[0];
            }
        });
        for (int i = 1; i < len; i++) {
            int tem1 = people[i][0];
            int tem2 = people[i][1];
            int k = i;
            int gap = i - tem2;
            for (int m = 0; m < gap; m++) {
                people[k][0] = people[k - 1][0];
                people[k][1] = people[k - 1][1];
                k--;
            }
            people[k][0] = tem1;
            people[k][1] = tem2;
        }
        return people;
    }
}
