package com.huluhaziqi.algorithms.algorithms.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * [LeetCode] Two Sum 两数之和
 * <p>
 * <p>
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class LeetCode01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            String[] strings = string.split(" ");
            int[] nums = new int[strings.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(strings[i]);
            }
            String targetString = scanner.nextLine();
            int target = Integer.parseInt(targetString);
            int[] result = sumTwo(nums, target);
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
        }
    }

    public static int[] sumTwo(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        throw new IllegalArgumentException();
    }
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i< nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            } else {
                map.put(nums[i],i);
            }
        }
        throw new IllegalArgumentException();

    }
}