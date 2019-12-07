package com.huluhaziqi.algorithms.algorithms.binary_search;

public class BinarySearch {

    public static void main(String[] args) {
        int nums[] = {5, 7, 7, 8, 8, 8, 9, 9, 9, 10};
        int result = new BinarySearch().binarySearch4(nums, 8);
        System.out.println(result);
        result = new BinarySearch().binarySearchFirst(nums, 8);
        System.out.println(result);
        result = new BinarySearch().binarySearchLast(nums, 8);
        System.out.println(result);

    }

    public int binarySearch(int[] nums, int key) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        int mid = low + (high - low) / 2;
        while (low <= high) {
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            mid = low + (high - low) / 2;
        }
        return low;
    }

    public int binarySearch2(int[] array, int target) {
        int l = 0;
        int r = array.length - 1;
        int mid = l + (r - l) / 2;
        while (l < r) {
            if (array[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
            mid = l + (r - l) / 2;
        }
        return l;
    }

    public int binarySearch3(int[] array, int target) {
        int l = 0;
        int r = array.length - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (array[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public int binarySearch4(int array[], int target) {
        int l = 0;
        int r = array.length - 1;
        while ((l <= r)) {
            int mid = (l + r) / 2;
            ;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * return fist target or if not find target return the insert index
     *
     * @param array
     * @param target
     * @return
     */
    public int binarySearchFirst(int array[], int target) {
        int l = 0;
        int r = array.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            ;
            if (array[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * find the last target index
     *
     * @param array
     * @param target
     * @return
     */
    public int binarySearchLast(int array[], int target) {
        int l = 0;
        int r = array.length - 1;
        while ((l < r)) {
            int mid = l + (r - l) / 2;
            ;
            if (array[mid] <= target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

}
