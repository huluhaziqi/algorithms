package com.huluhaziqi.algorithms.algorithms.algorithm.jianzhioffer;

import java.util.*;

public class PrintMinNumber {


    public static void main(String[] args) {
        int[] numbers = {3, 323, 32123};
        String result = PrintMinNumber(numbers);
        System.out.println(result);
    }

    //此版本不对
    public static class Solution {
        public String PrintMinNumber(int[] numbers) {
            if (numbers == null || numbers.length == 0) {
                return "";
            }
            bulletSort(numbers);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < numbers.length; i++) {
                sb.append(numbers[i]);
            }
            return sb.toString();
        }

        public void bulletSort(int[] numbers) {
            if (numbers == null || numbers.length == 0) {
                return;
            }
            int max = max(numbers);
            int len = len(max);
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                list.add(new ArrayList<>());
            }
            int pow = pow(len - 1);
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < numbers.length; j++) {
                    int tem = numbers[j] / pow(len - 1 - i) % 10;
                    list.get(tem).add(numbers[j]);
                }
                pow /= 10;
                int k = 0;
                for (int m = 0; m < list.size(); m++) {
                    List<Integer> subList = list.get(m);
                    for (int j = 0; j < subList.size(); j++) {
                        numbers[k++] = subList.get(j);
                    }
                    subList.clear();
                }
            }

        }

        public int pow(int n) {
            return (int) Math.pow(10, n);
        }

        public int len(int num) {
            int ret = 0;
            while (num != 0) {
                num /= 10;
                ret++;
            }
            return ret;
        }

        public int max(int[] numbers) {
            int max = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] > max) {
                    max = numbers[i];
                }
            }
            return max;
        }

    }


    public static String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        Integer[] tem = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            tem[i] = numbers[i];
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(tem, new My());
        for (int i = 0; i < numbers.length; i++) {
            sb.append(tem[i]);
        }
        return sb.toString();
    }

    public static class My implements Comparator<Integer> {
        @Override
        public int compare(Integer s1, Integer s2) {
            String c1 = s1 + "" + s2;
            String c2 = s2 + "" + s1;
            return c1.compareTo(c2);
        }
    }

}
