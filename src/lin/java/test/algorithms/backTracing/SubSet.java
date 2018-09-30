package lin.java.test.algorithms.backTracing;

import java.util.ArrayList;
import java.util.List;

public class SubSet {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3,4};
        List<List<Integer>> result = new SubSet().subsets(nums);
        result.forEach(o->{
            o.forEach(p-> System.out.print(p + " "));
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

//    public List<List<Integer>> subsets2(int[] nums){
//        List<List<Integer>> result = new ArrayList<>();
//        return result;
//    }

}
