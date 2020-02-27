package com.huluhaziqi.algorithms.algorithms.backTracing;

import java.util.*;

public class Combinations {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> result = new Combinations().combine(n, k);
        result.forEach(o -> {
            o.forEach(p -> System.out.print(p + " "));
            System.out.print("     ");
        });
    }


    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];

        backTracing(n, k, 1, new ArrayList<>(), result);

        return result;
    }

    public void backTracing(int n, int k, int start, List<Integer> value, List<List<Integer>> ret) {
        if (value.size() == k) {
            ret.add(new ArrayList<>(value));
            return;
        }

        for (int i = start; i <= n; i++) {
            value.add(i);
            backTracing(n, k, i + 1, value, ret);
            value.remove(value.size() - 1);
        }
    }

    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            if (k > n) {
                return new ArrayList<>();
            }
            List<List<Integer>> result = new ArrayList<>();
            boolean[] visited = new boolean[n];
            dfs(n, k, 1, new ArrayList<>(), result);
            return result;
        }

        void dfs(int n, int k, int i, List<Integer> list, List<List<Integer>> result) {
            if (list.size() == k) {
                result.add(new ArrayList<>(list));
                return;
            }
            for (int x = i; x <= n; x++) {
                list.add(x);
                dfs(n, k, x + 1, list, result);
                list.remove(list.size() - 1);
            }
        }
    }
}
