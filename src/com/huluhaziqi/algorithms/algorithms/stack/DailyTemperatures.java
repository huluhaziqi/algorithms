package com.huluhaziqi.algorithms.algorithms.stack;

import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {

    }
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            if(temperatures == null || temperatures.length == 0){
                return new int[0];
            }
            int n = temperatures.length;
            int[] dis = new int[n];
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < n; i++){
                if(stack.isEmpty() || temperatures[stack.peek()] >= temperatures[i]){
                    stack.push(i);
                }else{
                    while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                        dis[stack.peek()] = i - stack.peek();
                        stack.pop();
                    }
                    stack.push(i);
                }
            }
            while(!stack.isEmpty()){
                dis[stack.pop()] = 0;
            }
            return dis;
        }
    }
}


