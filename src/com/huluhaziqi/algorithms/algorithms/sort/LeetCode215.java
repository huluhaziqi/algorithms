package com.huluhaziqi.algorithms.algorithms.sort;

public class LeetCode215 {
//    top k
//    Input: [3,2,1,5,6,4] and k = 2
//    Output: 5
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            if(k > nums.length ){
                return 0;
            }
            for(int i = 0; i <k; i++){
                int s = i + 1;
                int e = nums.length - 1;
                while(s <= e){
                    while(e >= s && nums[e] < nums[i]){
                        e--;
                    }
                    if(e >= s && nums[e] > nums[i]){
                        swap(nums, e, i);
                        e--;
                    }
                    while(e >= s && nums[s] <= nums[i]){
                        s++;
                    }
                    if(e >= s && nums[s] > nums[i]){
                        swap(nums, s, i);
                        s++;
                    }
                }
            }
            return nums[k - 1];
        }
        public void swap(int nums[], int e, int i){
            int tem = nums[e];
            nums[e] = nums[i];
            nums[i] = tem;
        }
    }

    // heap sort for max k
    class Solution2 {
        public int findKthLargest(int[] nums, int k) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            buildMaxHeap(nums);
            for(int i = 0; i < k; i++){
                swap(nums, 0, nums.length - i - 1);
                heapify(nums,0, nums.length - i - 2);
            }
            return nums[nums.length - k];
        }

        public void heapify(int[] nums, int p, int end){
            int parent = p;
            while(parent <= end){
                int right = parent *2 + 1 ;
                int left = parent * 2;
                int max = parent;
                if(left <= end && nums[max] < nums[left]){
                    max = left;
                }
                if(right <= end && nums[max] < nums[right]){
                    max = right;
                }
                if(parent != max){
                    swap(nums,parent, max);
                    parent = max;
                } else {
                    break;
                }
            }
        }

        public void buildMaxHeap(int nums[]) {
            if(nums == null || nums.length == 0){
                return;
            }
            for(int i = nums.length / 2 + 1; i >= 0; i--){
                heapify(nums,i, nums.length - 1);
            }
        }

        public void swap(int[] nums, int i, int j){
            int tem = nums[i];
            nums[i] = nums[j];
            nums[j] = tem;
        }

    }
}
