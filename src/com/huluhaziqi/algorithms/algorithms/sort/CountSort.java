package com.huluhaziqi.algorithms.algorithms.sort;

public class CountSort {

    public static void main(String[] args) {
        int[] array = {12,10000000};
        new CountSort().countSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

     public void countSort(int[] array){
        if(array == null || array.length <= 1){
            return;
        }
        int max = Integer.MIN_VALUE;
        for(int i : array){
            max = Math.max(i,max);
        }
         int[] tem = new int[max + 1];
        for(int i :array){
            tem[i]++;
        }
        int index = 0;
        for(int i = 0; i <= max; i++){
            while (tem[i]-- > 0){
                array[index++] = i;
            }
        }
     }
}
