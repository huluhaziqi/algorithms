package com.huluhaziqi.algorithms.algorithms.backTracing;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    /**
     * 216. Combination Sum III
     * Medium
     * <p>
     * 848
     * <p>
     * 46
     * <p>
     * Add to List
     * <p>
     * Share
     * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
     * <p>
     * Note:
     * <p>
     * All numbers will be positive integers.
     * The solution set must not contain duplicate combinations.
     * Example 1:
     * <p>
     * Input: k = 3, n = 7
     * Output: [[1,2,4]]
     * Example 2:
     * <p>
     * Input: k = 3, n = 9
     * Output: [[1,2,6], [1,3,5], [2,3,4]]
     * Accepted
     * 149,997
     * Submissions
     * 274,690
     *
     * @param args
     */
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backTracing(k, n, 1, new ArrayList<>(), result);
        return result;
    }

    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public void backTracing(int k, int n, int start, List<Integer> value, List<List<Integer>> ret) {
        if (value.size() == k && n == 0) {
            ret.add(new ArrayList<>(value));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (n < i) {
                continue;
            }
            value.add(i);
            backTracing(k, n - i, i + 1, value, ret);
            value.remove(value.size() - 1);
        }
    }

    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> result = new ArrayList<>();
            if (k > n) {
                return result;
            }
            dfs(k, n, new ArrayList<>(), result, 0, 1);
            return result;
        }

        void dfs(int k, int n, List<Integer> list, List<List<Integer>> result, int value, int index) {
            if (value >= n || list.size() >= k) {
                if (value == n && list.size() == k) {
                    result.add(new ArrayList<>(list));
                }
                return;
            }
            for (int i = index; i <= n; i++) {
                if (i > 9) {
                    continue;
                }
                value += i;
                list.add(i);

                dfs(k, n, list, result, value, i + 1);
                value -= i;
                list.remove(list.size() - 1);
            }

        }
    }


}
