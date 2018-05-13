package lin.java.test.algorithms.greedy;

public class NonDecreasingArray {

    public static void main(String[] args) {
        int[] nums = {4,2,3};
        System.out.println(new NonDecreasingArray().checkPossibility(nums));
    }

    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int count = 0;
        for (int i = 1; i < nums.length && count < 2; i++) {
            if (nums[i - 1] <= nums[i]) {
                continue;
            }
            count++;
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else {
                nums[i - 1] = nums[i];
            }
        }
        return count <= 1;
    }
}
