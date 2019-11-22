package com.huluhaziqi.algorithms.algorithms.greedy;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = {1,0,0,0,1};
        boolean result = new CanPlaceFlowers().canPlaceFlowers(flowerbed,2);
        System.out.println(result);
    }
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed == null || flowerbed.length == 0 || n > flowerbed.length){
            return false;
        }
        int count = 0;
        for(int i = 0; i < flowerbed.length; i++){
            int pre = (i == 0) ? 0 : flowerbed[i - 1];
            int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
            if(pre == 0 &&  next == 0 && flowerbed[i] != 1){
                flowerbed[i] = 1;
                count++;
                System.out.println(count);
            }
        }
        return n <= count ;
    }
}
