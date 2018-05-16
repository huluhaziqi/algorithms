package lin.java.test.algorithms.backTracing;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

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

}
