package lin.java.test.algorithms.heap;

import java.util.*;

public class MergekSortedLists {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        List<Integer> result = new MergekSortedLists().topKFrequent(nums, 2);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        List<List<Integer>> radix = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            radix.add(new ArrayList<>());
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            int index = (int) entry.getValue();
            radix.get(index).add((int) entry.getKey());
        }
        List<Integer> result = new ArrayList<>();
        for (int i = radix.size() - 1; i >= 0 && k > 0; i--) {
            List<Integer> tem = radix.get(i);
            for (int j = 0; j < tem.size() && k > 0; j++) {
                result.add(tem.get(j));
                k--;
            }
        }
        return result;
    }
}
