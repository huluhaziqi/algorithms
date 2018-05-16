package lin.java.test.algorithms.backTracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationsSum {

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> result = new CombinationsSum().combinationSum(candidates,target);
        result.forEach(o->{
            o.forEach(p-> System.out.print(p + " "));
            System.out.print("     ");
        });
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,0, target,new ArrayList<>(),result);
        return result;
    }

    void dfs(int[] candidates,int start, int target, List<Integer> value, List<List<Integer>> ret){
        if(0 == target){
            ret.add(new ArrayList<>(value));
            return;
        }
        for(int i = start; i < candidates.length;i++){
            if(candidates[i] <= target) {
                value.add(candidates[i]);
                dfs(candidates, i,target - candidates[i], value, ret);
                value.remove(value.size() - 1);
            }
        }
    }
    int sum(List<Integer> value){
        int sum = 0;
        for(int v : value){
            sum += v;
        }
        return sum;
    }
}
