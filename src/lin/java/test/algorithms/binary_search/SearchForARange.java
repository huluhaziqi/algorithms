package lin.java.test.algorithms.binary_search;

import java.util.Arrays;

public class SearchForARange {

    public static void main(String[] args) {
        int[] nums = {2,2};
        int target = 2;
        int index = new SearchForARange().maxIndex(nums,target);
        System.out.println(index);
    }
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.fill(result, -1);
        if (nums == null || nums.length == 0) {
            return result;
        }
        int l = minIndex(nums, target);
        int r = l;
        System.out.println("l " + l + " r " + r);
        if (l >= 0 && l < nums.length - 1 && nums[l] == target) {
            result[0] = l;
            while(r < nums.length && nums[r] == target){
                r++;
            }
            result[1] = r;
        }
        return result;
    }

    public int minIndex(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public int maxIndex(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = (l + r + 1) / 2;
            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        return r;

    }

}
