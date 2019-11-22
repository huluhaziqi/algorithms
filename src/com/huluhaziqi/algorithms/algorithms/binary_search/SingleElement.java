package com.huluhaziqi.algorithms.algorithms.binary_search;

public class SingleElement {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 4, 4, 5, 5,9};
        int result = new SingleElement().singleNonDuplicate(nums);
        System.out.println(nums[result]);
    }

    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]){
                return mid;
            }
            if ((mid % 2 == 1 && nums[mid] == nums[mid + 1]) ||
                    (mid % 2 == 0 && nums[mid] == nums[mid - 1])) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
