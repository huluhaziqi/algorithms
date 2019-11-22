package com.huluhaziqi.algorithms.algorithms.algorithm.jianzhioffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class MaxInWindow {

    public static void main(String[] args) {

    }

    public class Solution {
        public ArrayList<Integer> maxInWindows(int[] num, int size) {
            ArrayList<Integer> result = new ArrayList<>();
            if (num == null || num.length == 0 || size == 0 || size > num.length) {
                return result;
            }
            Deque<Integer> deque = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                while (!deque.isEmpty() && num[deque.getLast()] < num[i]) {
                    deque.pollLast();
                }
                deque.add(i);
            }

            for(int i = size; i < num.length;i++){
                result.add(num[deque.getFirst()]);
                while (!deque.isEmpty() && num[deque.getLast()] < num[i]){
                    deque.pollLast();
                }
                if(!deque.isEmpty() && deque.getFirst() <= i - size){
                    deque.pollFirst();
                }
                deque.offer(i);
            }
            result.add(num[deque.getFirst()]);
            return result;
        }
    }
}
