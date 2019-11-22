package com.huluhaziqi.algorithms.algorithms.algorithm.jianzhioffer;

public class Solution10 {
    //题目描述
    //我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
        public int RectCover(int target) {
            if(target <= 0){
                return 0;
            }
            if(target <=2){
                return target;
            }
            int prepre = 1;
            int pre = 2;
            int cur = 0;
            for(int i = 3; i <= target;i++){
                cur = prepre + pre;
                prepre = pre;
                pre = cur;
            }
            return cur;
        }
}
