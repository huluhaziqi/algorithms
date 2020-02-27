package com.huluhaziqi.algorithms.algorithms.backTracing;


import java.util.*;

public class CombinationSum4 {

    /**
     * leetcode 40
     * 40. Combination Sum II
     * Medium
     * <p>
     * 1339
     * <p>
     * 55
     * <p>
     * Add to List
     * <p>
     * Share
     * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
     * <p>
     * Each number in candidates may only be used once in the combination.
     * <p>
     * Note:
     * <p>
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     * Example 1:
     * <p>
     * Input: candidates = [10,1,2,7,6,1,5], target = 8,
     * A solution set is:
     * [
     * [1, 7],
     * [1, 2, 5],
     * [2, 6],
     * [1, 1, 6]
     * ]
     * Example 2:
     * <p>
     * Input: candidates = [2,5,2,1,2], target = 5,
     * A solution set is:
     * [
     * [1,2,2],
     * [5]
     * ]
     * Accepted
     * 286,949
     * Submissions
     * 629,067
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 2;
        int result = new CombinationSum4().combinationSum4(nums, target);
        System.out.println(result);
    }

    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        dfs(nums, new ArrayList<>(), target);
        return v;
    }

    int v = 0;

    void dfs(int[] nums, List<Integer> value, int target) {
        if (sum(value) == target) {
            v++;
            return;
        }
        if (sum(value) > target) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            value.add(nums[i]);
            dfs(nums, value, target);
            value.remove(value.size() - 1);
        }
    }

    int sum(List<Integer> value) {
        int sum = 0;
        for (int v : value) {
            sum += v;
        }
        return sum;
    }

    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            if (candidates == null || candidates.length == 0) {
                return new ArrayList<>();
            }
            Arrays.sort(candidates);
            boolean[] visited = new boolean[candidates.length];
            List<List<Integer>> result = new ArrayList<>();
            dfs(candidates, 0, target, 0, result, new ArrayList<>(), visited);
            return result;

        }

        void dfs(int[] candidates, int value, int target, int level, List<List<Integer>> result, List<Integer> list, boolean[] visited) {
            if (value == target) {
                result.add(new ArrayList<>(list));
                return;
            }
            if (value > target) {
                return;
            }

            for (int i = level; i < candidates.length; i++) {
                if (target - value < candidates[i]) {
                    continue;
                }
                if (i > 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
                    continue;
                }
                if (visited[i]) {
                    continue;
                }

                visited[i] = true;
                list.add(candidates[i]);
                value += candidates[i];
                dfs(candidates, value, target, i, result, list, visited);
                list.remove(list.size() - 1);
                value -= candidates[i];
                visited[i] = false;
            }
        }

    }
}
