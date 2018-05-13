package lin.java.test.algorithms.dynamic_programming;

import java.util.Arrays;

public class UglyNumber {

    public static void main(String[] args) {
        int n = 11;
        UglyNumber uglyNumber = new UglyNumber();
        int result = uglyNumber.nthUglyNumber2(n);
    }

    public int nthUglyNumber(int n) {//LIM
        if (n <= 0) {
            return 0;
        }
        boolean[] nums = new boolean[1000000];
        Arrays.fill(nums, false);
        nums[1] = true;
        int tem = 0;
        int i = 1;
        for (; i < 1000000 && tem <= n; i++) {
            if (nums[i] == true) {
                tem++;
                if (i * 2 < 1000000)
                    nums[i * 2] = true;
                if (i * 3 < 1000000)
                    nums[i * 3] = true;
                if (i * 5 < 1000000)
                    nums[i * 5] = true;
            } else {
                continue;
            }
        }
        return i;
    }

    public int nthUglyNumber2(int n) {
        if (n <= 0) {
            return 0;
        }
        int m2 = 0, m3 = 0, m5 = 0;
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result = Math.min((m2 + 1) * 2, (m3 + 1) * 3);
            result = Math.min(result, (m5 + 1) * 5);
            if (result == (m2 + 1) * 2) {
                m2++;
            }
            if (result == (m3 + 1) * 3) {
                m3++;
            }
            if (result == (m5 + 1) * 5) {
                m5++;
            }
        }
        return result;
    }

}
