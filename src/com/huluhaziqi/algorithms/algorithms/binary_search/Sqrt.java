package com.huluhaziqi.algorithms.algorithms.binary_search;

public class Sqrt {

    public static void main(String[] args) {
        int x = 8;
        int result = new Sqrt().mySqrt(x);
        System.out.println(result);
    }

    public int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        long l = 1;
        long r = x / 2 + 1;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) r;
    }

    class Solution {
        public int mySqrt(int x) {
            if(x <= 0){
                return 0;
            }
            int l = 1;
            int r = x / 2 + 1;
            while(l <= r){
                int mid = (r - l) / 2 + l;
                if(mid == x / mid){
                    return mid;
                } else if(mid > x / mid){
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return r;
        }
    }
}
