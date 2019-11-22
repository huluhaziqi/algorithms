package com.huluhaziqi.algorithms.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 7, 2, 1, 67, 8, 3, 4, 5, 0};
        new RadixSort().radixSort2(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public void radixSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int len = array.length;
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            max = Math.max(max, i);
        }
        int digitalLen = 0;
        while (max > 0) {
            max = max / 10;
            digitalLen++;
        }
        List<List<Integer>> radix = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            radix.add(new ArrayList<>());
        }
        int base = 10;
        for (int i = 1; i <= digitalLen; i++) {
            for (int j = 0; j < array.length; j++) {
                int tem = array[j];
                int index = (tem % base) / (base / 10);
                radix.get(index).add(tem);
            }

            int k = 0;
            for (int m = 0; m < radix.size(); m++) {
                List<Integer> list = radix.get(m);
                for (int n = 0; n < list.size(); n++) {
                    array[k++] = list.get(n);
                }
                list.clear();
            }
            base *= 10;
        }
    }

    public void radixSort2(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int len = array.length;
        int max = array[0];
        for (int i : array) {
            if (max < i) {
                max = i;
            }
        }
        int maxLen = 0;
        while (max > 0) {
            maxLen++;
            max /= 10;
        }
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new ArrayList<>());
        }
        int base = 10;
        while ((maxLen--) > 0) {
            for (int a : array) {
                int index = (a % base) / (base / 10);
                list.get(index).add(a);
            }
            int c = 0;
            for (List<Integer> l : list) {
                for (int i : l) {
                    array[c++] = i;
                }
                l.clear();
            }
            base *=10;
        }
    }

}
