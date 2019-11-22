package com.huluhaziqi.algorithms.algorithms.algorithm.jianzhioffer;

import java.util.Arrays;

public class FirstAppearOnce {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "!@$%^&*()_";
        for(int i = 0; i < str.length(); i++){
            solution.Insert(str.charAt(i));
        }
        solution.FirstAppearingOnce();
    }

    public static class Solution {
        //Insert one char from stringstream
        public int a = 0;
        public void Insert(char ch)
        {
            if(num[(int) ch] == -1){
                num[ch] = a++;
            }else if(num[ch] >= 0){
                num[ch] = -2;
            }
        }
        Solution(){
            Arrays.fill(num,-1);
        }
        public int[] num = new int[256];
        //return the first appearence once char in current stringstream
        public char FirstAppearingOnce()
        {
            int min =Integer.MAX_VALUE;
            int index = -1;
            for(int i = 0; i < 256;i++){
                if(num[i] >= 0){
                    if(num[i] < min){
                        index = i;
                        min = num[i];
                    }
                }
            }
            return (index == -1) ? '#' : (char) (index);
        }
    }
}
