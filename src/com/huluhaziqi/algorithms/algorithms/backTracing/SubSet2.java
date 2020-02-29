package com.huluhaziqi.algorithms.algorithms.backTracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet2 {


    /**
     * 90. Subsets II
     * Medium
     * <p>
     * 1342
     * <p>
     * 58
     * <p>
     * Add to List
     * <p>
     * Share
     * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
     * <p>
     * Note: The solution set must not contain duplicate subsets.
     * <p>
     * Example:
     * <p>
     * Input: [1,2,2]
     * Output:
     * [
     * [2],
     * [1],
     * [1,2,2],
     * [2,2],
     * [1,2],
     * []
     * ]
     * Accepted
     * 250,548
     * Submissions
     * 553,270
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new SubSet2().subsetsWithDup(nums);
        result.forEach(o -> {
            o.forEach(p -> System.out.print(p + " "));
            System.out.print("   ");
        });
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(nums, new ArrayList<>(), visited, 0, result);
        return result;
    }

    public void dfs(int[] nums, List<Integer> value, boolean[] visited, int start, List<List<Integer>> ret) {
        if (start > nums.length) {
            return;
        }
        ret.add(new ArrayList<>(value));
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            value.add(nums[i]);
            dfs(nums, value, visited, i + 1, ret);
            value.remove(value.size() - 1);
            visited[i] = false;
        }
    }

    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new ArrayList<>();
            }
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            dfs(nums, new ArrayList<>(), result, 0, visited);
            return result;
        }

        void dfs(int[] nums, List<Integer> list, List<List<Integer>> result, int index, boolean[] visited) {
            result.add(new ArrayList<>(list));
            for (int i = index; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                list.add(nums[i]);
                dfs(nums, list, result, i + 1, visited);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }

    }
}
