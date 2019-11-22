package com.huluhaziqi.algorithms.algorithms.binary_search;

public class Sqrt {

    public static void main(String[] args) {
        int x = 8;
        int result = new Sqrt().mySqrt(x);
        System.out.println(result);
    }

    public int mySqrt(int x) {
        if(x <= 0){
            return 0;
        }
        int l = 1;
        int r = x;
        int mid = (r - l) / 2 + l;
        while(l < r){
            if(mid * mid == x){
                return mid;
            } else if(mid * mid > x){
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }
}
