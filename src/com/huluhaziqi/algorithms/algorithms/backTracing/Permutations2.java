package com.huluhaziqi.algorithms.algorithms.backTracing;

import java.util.*;
import java.util.stream.Collectors;

public class Permutations2 {

    public static void main(String[] args) {
        int[] nums = {1,1,2, 2, 3};
        List<List<Integer>> result = new Permutations2().permuteUnique(nums);
        for (List<Integer> o : result) {
            for (int i : o) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Set<List<Integer>> ret = new HashSet<>();
        backTracint2(nums, new ArrayList<>(), visited, ret);
        return ret.stream().collect(Collectors.toList());
    }

    public void backTracint2(int[] nums, List<Integer> value, boolean[] visited, Set<List<Integer>> ret) {
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
            backTracint2(nums, value, visited, ret);
            value.remove(value.size() - 1);
            visited[i] = false;
        }
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backTracint(nums, new ArrayList<>(), visited, result);
        return result;
    }

    public void backTracint(int[] nums, List<Integer> value, boolean[] visited, List<List<Integer>> ret) {
        if (value.size() == nums.length) {
            ret.add(new ArrayList<>(value));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if ((i > 0 && nums[i] == nums[i - 1]) && !visited[i - 1]) {
                continue;
            }
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            value.add(nums[i]);
            backTracint(nums, value, visited, ret);
            value.remove(value.size() - 1);
            visited[i] = false;
        }
    }
}
