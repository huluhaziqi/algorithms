package lin.java.test.algorithms.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LongestHarmoniousSubsequence {

    public static void main(String[] args) {

    }

    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n).intValue() + 1);
            } else {
                map.put(n, 1);
            }
        }
        int max = 0;

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            int tem = entry.getValue();
            if (map.containsKey(entry.getKey() + 1)) {
                max = Math.max(max, tem + map.get(entry.getKey() + 1));
            }
            if (map.containsKey(entry.getKey() - 1)) {
                max = Math.max(max, tem + map.get(entry.getKey() - 1));
            }
        }
        return max;
    }
}
