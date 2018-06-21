package lin.java.test.algorithms.jianzhioffer;

public class Solution08 {
//    题目描述
//    一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
    public int JumpFloor(int target) {
        if (target == 1 || target == 2) {
            return target;
        }
        int pre = 2;
        int prepre = 1;
        int cur = 0;
        for (int i = 3; i <= target; i++) {
            cur = prepre + pre;
            prepre = pre;
            pre = cur;
        }
        return cur;
    }
}
