package com.huluhaziqi.algorithms.algorithms.jianzhioffer;

public class Solution07 {
    public int Fibonacci(int n) {
        if (n == 2 || n == 1) {
            return 1;
        }
        int prepre = 1;
        int pre = 1;
        int cur = 0;
        for (int i = 3; i <= n; i++) {
            cur = pre + prepre;
            prepre = pre;
            pre = cur;
        }
        return cur;
    }
}
