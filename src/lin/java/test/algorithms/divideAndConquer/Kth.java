package lin.java.test.algorithms.divideAndConquer;

public class Kth {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = new Kth().findKthLargest(nums, k);
        System.out.println(result);
    }

    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        buildMaxHeap(nums);
        for (int i = 1; i <= k; i++) {
            int tem = nums[len - i];
            nums[len - i] = nums[0];
            nums[0] = tem;
            heaptify(nums, 0, len - i - 1);
        }
        return nums[len - k];
    }

    public void buildMaxHeap(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) {
            heaptify(nums, i, nums.length - 1);
        }
    }

    void heaptify(int[] nums, int x, int len) {
        int parent = x;
        while (parent <= len) {
            int max = parent;
            int lChild = 2 * parent + 1;
            int rChild = 2 * parent + 2;
            if (lChild <= len && nums[lChild] > nums[max]) {
                max = lChild;
            }
            if (rChild <= len && nums[rChild] > nums[max]) {
                max = rChild;
            }
            if (max != parent) {
                int tem = nums[max];
                nums[max] = nums[parent];
                nums[parent] = tem;
                parent = max;
            } else {
                break;
            }
        }
    }

    //**快排思想

    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int tem = partition(nums, left, right);
            if (tem == k - 1) {
                return nums[k - 1];
            } else if (tem > k - 1) {
                right = tem - 1;
            } else {
                left = tem + 1;
            }
        }

    }

    int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            while (nums[l] > pivot) {
                l++;
            }
            while (nums[r] <= pivot) {
                r--;
            }
            if (l < r) {
                int tem = nums[l];
                nums[l] = nums[r];
                nums[r] = tem;
                l++;
                r--;
            }
        }
        nums[left] = nums[r];
        nums[r] = pivot;
        return r;
    }


}
