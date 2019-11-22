package com.huluhaziqi.algorithms.algorithms.sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] array = {3,0};
        new SelectSort().selectSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public void selectSort(int[] array){
        if(array == null || array.length == 0){
            return;
        }
        for(int i = 0; i < array.length ;i++){
            int minIndex = i;
            for(int j = i + 1; j < array.length; j++){
                if(array[minIndex] > array[j]){
                    minIndex = j;
                }
            }
            swap(array,minIndex,i);
        }
    }

    public void swap(int[] array, int a, int b) {
        int tem = array[a];
        array[a] = array[b];
        array[b] = tem;
    }
}
