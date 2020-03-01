package com.huluhaziqi.algorithms.algorithms.binary_search;

public class SingleElement {

    public static void main(String[] args) {
//        int[] nums = {1, 1, 2, 2, 4, 4, 5, 5, 9};
//        int result = new SingleElement().singleNonDuplicate(nums);
//        System.out.println(nums[result]);
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int result = new Solution().singleNonDuplicate(nums);
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
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
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

    static class Solution {
        public int singleNonDuplicate(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                int len1 = mid - l;
                if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                    return nums[mid];
                }
                if (len1 % 2 == 0) {
                    if (nums[mid] == nums[mid - 1]) {
                        r = mid;
                    } else if (nums[mid] == nums[mid + 1]) {
                        l = mid;
                    }
                }
                if (len1 % 2 == 1) {
                    if (nums[mid] == nums[mid + 1]) {
                        r = mid - 1;
                    } else if (nums[mid] == nums[mid - 1]) {
                        l = mid + 1;
                    }
                }

            }
            return nums[l];

        }
    }

    /**
     * 全部异或
     */
    class Solution2 {
        public int singleNonDuplicate(int[] nums) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            int first = nums[0];
            for (int i = 1; i < nums.length; i++) {
                first ^= nums[i];
            }
            return first;
        }
    }

    class Solution3 {
        public int singleNonDuplicate(int[] nums) {
            int l = 0, h = nums.length - 1;
            while (l < h) {
                int m = l + (h - l) / 2;
                if (m % 2 == 1) {
                    m--;   // 保证 l/h/m 都在偶数位，使得查找区间大小一直都是奇数
                }
                if (nums[m] == nums[m + 1]) {
                    l = m + 2;
                } else {
                    h = m;
                }
            }
            return nums[l];
        }
    }
}
