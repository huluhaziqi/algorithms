package com.huluhaziqi.algorithms.algorithms.backTracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet2 {


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
}
