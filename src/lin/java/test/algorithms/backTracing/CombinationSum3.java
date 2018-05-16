package lin.java.test.algorithms.backTracing;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backTracing(k,n,1,new ArrayList<>(),result);
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


}
