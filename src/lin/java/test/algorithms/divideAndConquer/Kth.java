package lin.java.test.algorithms.divideAndConquer;

public class Kth {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = new Kth().findKthLargest(nums, k);
        System.out.println(result);
    }

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        buildMaxHeap(nums);
        for(int i = 1; i <= k; i++){
            int tem = nums[len  - i];
            nums[len - i] = nums[0];
            nums[0] = tem;
            heaptify(nums,0,len - i - 1);
        }
        return nums[len - k];
    }
    public void buildMaxHeap(int[] nums){
        for(int i = nums.length / 2; i >=0 ;i --){
            heaptify(nums,i,nums.length - 1);
        }
    }
    void heaptify(int[] nums,int x,int len){
        int parent = x;
        while(parent <= len){
            int max = parent;
            int lChild = 2 * parent + 1;
            int rChild = 2 * parent + 2;
            if(lChild <= len && nums[lChild] > nums[max]){
                max = lChild;
            }
            if(rChild <= len && nums[rChild] > nums[max]){
                max = rChild;
            }
            if(max != parent){
                int tem = nums[max];
                nums[max] = nums[parent];
                nums[parent] = tem;
                parent = max;
            } else {
                break;
            }
        }
    }

}
