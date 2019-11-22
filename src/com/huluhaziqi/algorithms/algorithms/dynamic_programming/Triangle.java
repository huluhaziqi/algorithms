package com.huluhaziqi.algorithms.algorithms.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        Integer[][] tem = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        for (int i = 0; i < tem.length; i++) {
            List<Integer> temList = Arrays.asList(tem[i]);
            triangle.add(temList);
        }
        Triangle triangle1 = new Triangle();
        int result = triangle1.minimumTotal(triangle);
        System.out.println(result);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int size = triangle.size();
        int len = triangle.get(triangle.size() - 1).size();

        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (j > 0 && j < list.size() - 1) {
                    int tem = Math.min(dp[j - 1], dp[j]);
                    dp[j] = Math.min(tem, dp[j + 1]) + list.get(j);
                } else if (j == 0) {
                    dp[j] = Math.min(dp[j], dp[j + 1]) + list.get(j);
                } else if (j == list.size() - 1) {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + list.get(j);
                }
            }
        }
        int min = dp[0];
        for (int i = 1; i < len; i++) {
            min = Math.min(dp[i], min);
        }
        return min;
    }
}
