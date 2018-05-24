package lin.java.test.algorithms.stack;

import java.util.Stack;

public class NextGreateElement2 {


    public static void main(String[] args) {
        int[] nums = {1,2,1};
        int[] g = new NextGreateElement2().nextGreaterElements(nums);
        for (int i : g) {
            System.out.print(i + " ");
        }
    }

    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        int len = nums.length ;
        int[] g = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < len ;i++){
            g[i] = -1;
            for(int j = i + 1; j < 2 * len; j++){
                if(nums[j % len] > nums[i]){
                    g[i] = nums[j % len];
                    break;
                }
            }
        }
        return g;
    }
}
