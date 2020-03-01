package com.huluhaziqi.algorithms.algorithms.twosum;

//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
//
//        示例1:
//
//        输入: 5
//        输出: True
//        解释: 1 * 1 + 2 * 2 = 5

import java.util.ArrayList;
import java.util.List;

public class LeetCode633 {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        solution2.judgeSquareSum(9);
    }

    class Solution {
        public boolean judgeSquareSum(int c) {
            if (c < 0) {
                return false;
            }
            long i = 0;
            long j = (long) Math.sqrt(c) + 1;
            while (i <= j) {
                long tem = i * i + j * j;
                if (tem == c) {
                    return true;
                } else if (tem > c) {
                    j--;
                } else {
                    i++;
                }
            }
            return false;
        }
    }


    static class Solution2 {
        public boolean judgeSquareSum(int c) {
            if (c < 0) {
                return false;
            }
            List<Integer> list = generate(c);
            for (int i = 0; i < list.size(); i++) {
                int t = list.get(i);
                if (t > c) {
                    return false;
                }
                if (binary(list, c - t)) {
                    return true;
                }
            }
            return false;
        }

        boolean binary(List<Integer> list, int target) {
            int i = 0;
            int j = list.size() - 1;
            while (i <= j) {
                int mid = i + (j - i) / 2;
                if (list.get(mid) == target) {
                    return true;
                } else if (list.get(mid) > target) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            }
            return false;
        }

        List<Integer> generate(int c) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i <= Math.sqrt(c) + 1; i++) {
                result.add(i * i);
            }
            return result;
        }
    }
}
