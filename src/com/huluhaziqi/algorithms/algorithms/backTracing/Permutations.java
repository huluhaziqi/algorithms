package com.huluhaziqi.algorithms.algorithms.backTracing;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    /**
     * leetcode 46
     * 46. Permutations
     * Medium
     * <p>
     * 3078
     * <p>
     * 92
     * <p>
     * Add to List
     * <p>
     * Share
     * Given a collection of distinct integers, return all possible permutations.
     * <p>
     * Example:
     * <p>
     * Input: [1,2,3]
     * Output:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     * Accepted
     * 517,408
     * Submissions
     * 858,109
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new Permutations().permute2(nums);
        for (List<Integer> o : result) {
            for (int i : o) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = f(nums, nums.length - 1);
        return result;
    }

    public List<List<Integer>> f(int[] nums, int x) {
        if (x < 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> pre = f(nums, x - 1);
        if (pre.size() == 0) {
            List<Integer> tem = new ArrayList<>();
            tem.add(nums[0]);
            result.add(tem);
        } else {
            for (int i = 0; i <= x; i++) {
                for (List<Integer> p : pre) {
                    List<Integer> item = new ArrayList<>(p);
                    item.add(i, nums[x]);
                    result.add(item);
                }
            }
        }
        return result;
    }


    public List<List<Integer>> permute2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        backTracing(nums, visited, new ArrayList<>(), result);
        return result;
    }

    public void backTracing(int[] nums, boolean[] visited, List<Integer> value, List<List<Integer>> ret) {
        if (value.size() == nums.length) {
            ret.add(new ArrayList<>(value));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            value.add(nums[i]);
            backTracing(nums, visited, value, ret);
            value.remove(value.size() - 1);
            visited[i] = false;
        }
    }

    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            if (nums == null || nums.length == 0) {
                return new ArrayList<>();
            }
            int len = nums.length;
            boolean[] visited = new boolean[len];
            List<List<Integer>> ret = new ArrayList<>();
            backTracing(nums, new ArrayList<>(), visited, ret);
            return ret;
        }

        void backTracing(int[] nums, List<Integer> value, boolean[] visited, List<List<Integer>> ret) {
            if (value.size() == nums.length) {
                ret.add(new ArrayList<>(value));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                value.add(nums[i]);
                backTracing(nums, value, visited, ret);
                value.remove(value.size() - 1);
                visited[i] = false;
            }
        }
    }

    /**
     * bug free 一把过
     */
    class Solution3 {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length == 0) {
                return result;
            }
            boolean[] visited = new boolean[nums.length];
            dfs(nums, new ArrayList<>(), result, visited);
            return result;
        }

        void dfs(int[] nums, List<Integer> list, List<List<Integer>> result, boolean[] visited) {
            if (list.size() == nums.length) {
                result.add(new ArrayList<>(list));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                list.add(nums[i]);
                dfs(nums, list, result, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

}
