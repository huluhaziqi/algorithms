package lin.java.test.algorithms.dynamic_programming;

public class WiggleSubsequence {

    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 5};
        int result = new WiggleSubsequence().wiggleMaxLength(nums);
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int up = 1;
        int down = 1;
        for(int i = 1; i < nums.length;i++){
            if(nums[i] > nums[i - 1] ){
                up = down + 1;
            }else if(nums[i] < nums[i - 1]){
                down = up + 1;
            }
        }
        return Math.max(up,down);
    }
}
