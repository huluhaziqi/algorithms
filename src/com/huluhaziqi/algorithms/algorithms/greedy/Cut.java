package com.huluhaziqi.algorithms.algorithms.greedy;

public class Cut {

    public static void main(String[] args) {
        int n = 10;
        int result = new Cut().maxAfterCutting2(n);
        System.out.println(result);
    }

    public int maxAfterCutting2(int length) {
        if (length <= 0) {
            return 0;
        }
        if (length <= 1) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int[] f = new int[length + 1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;
        f[3] = 3;
        f[4] = 4;
        for (int i = 4; i <= length; i++) {
            int max = 0;
            for (int j = 0; j <= i / 2; j++) {
                max = Math.max(max, f[i - j] * f[j]);
            }
            f[i] = max;
        }
        return f[length];
    }

    public int maxAfterCutting(int length) {
        if (length <= 0) {
            return 0;
        }
        if (length <= 1) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int count_3 = 0;
        int tem = length;
        while (tem > 0) {
            tem = tem / 3;
            count_3++;
        }
        System.out.println(count_3);
        int count_2 = 0;
        if(length % 3 == 1){
            int tem2 = length - (--count_3 * 3);
            System.out.println(tem2);
            while (tem2 > 1){
                count_2++;
                tem2 = tem2 / 2;
                System.out.println("TEM2 " + tem2);
            }
        }
        System.out.println("count_ 2 " + count_2);
        System.out.println("count_3 " + count_3);
        return (int) (Math.pow(3,count_3) * Math.pow(2,count_2));
    }


}
