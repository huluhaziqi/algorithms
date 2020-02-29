package com.huluhaziqi.algorithms.algorithms.backTracing;

import java.util.ArrayList;
import java.util.List;

public class SubSet {

    /**
     * 78. Subsets
     * Medium
     * <p>
     * 2917
     * <p>
     * 69
     * <p>
     * Add to List
     * <p>
     * Share
     * Given a set of distinct integers, nums, return all possible subsets (the power set).
     * <p>
     * Note: The solution set must not contain duplicate subsets.
     * <p>
     * Example:
     * <p>
     * Input: nums = [1,2,3]
     * Output:
     * [
     * [3],
     * [1],
     * [2],
     * [1,2,3],
     * [1,3],
     * [2,3],
     * [1,2],
     * []
     * ]
     * Accepted
     * 486,627
     * Submissions
     * 839,676
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> result = new SubSet().subsets(nums);
        result.forEach(o -> {
            o.forEach(p -> System.out.print(p + " "));
            System.out.print("     ");
        });
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, new ArrayList<>(), 0, result);
        return result;
    }

    public void dfs(int[] nums, List<Integer> value, int start, List<List<Integer>> ret) {
        if (start > nums.length) {
            return;
        }
        ret.add(new ArrayList<>(value));
        for (int i = start; i < nums.length; i++) {
            value.add(nums[i]);
            dfs(nums, value, i + 1, ret);
            value.remove(value.size() - 1);
        }
    }

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new ArrayList<>();
            }
            List<List<Integer>> result = new ArrayList<>();
            dfs(nums, new ArrayList<>(), result, 0);
            return result;
        }

        void dfs(int[] nums, List<Integer> list, List<List<Integer>> result, int index) {
            result.add(new ArrayList<>(list));
            for (int i = index; i < nums.length; i++) {
                list.add(nums[i]);
                dfs(nums, list, result, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }

}
