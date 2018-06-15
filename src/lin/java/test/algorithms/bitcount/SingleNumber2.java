package lin.java.test.algorithms.bitcount;

public class SingleNumber2 {

    public static void main(String[] args) {
        int[] nums = {15};
        int result = new SingleNumber2().singleNumber2(nums);
        System.out.println(result);
    }

    public int singleNumber(int[] nums) {
        int[] b = new int[32];
        for (int i : nums) {
            int t = 0;
            while (i != 0 && t < 32) {
                if (((i >> t) & 1) == 1) {
                    b[t] = (b[t] + 1) % 3;
                }
                t++;
            }
        }
        int ret = 0;
        int t = 0;
        for (int i : b) {
            ret |= i << t;
            t++;
        }
        return ret;
    }

    public int singleNumber2(int[] nums) {
        int one = 0, two = 0, three = 0;
        for (int i = 0; i < nums.length; ++i) {
            two |= one & nums[i];
            one ^= nums[i];
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
}
