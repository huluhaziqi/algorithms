package lin.java.test.algorithms.algorithm.jianzhioffer;

import java.util.ArrayList;
import java.util.Stack;

public class IsPopOrder {

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};
        IsPopOrder1(pushA,popA);
    }
    public static boolean IsPopOrder1(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        if(pushA == null || popA == null || pushA.length != popA.length ){
            return false;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int len1 = pushA.length - 1;
        int cur = 0;

        for(int i = 0; i < popA.length; i++){
            if(stack.isEmpty() && cur > len1){
                return false;
            }
            while(stack.isEmpty() || (stack.peek()!= popA[i] && cur <= len1)){
                stack.push(pushA[cur++]);
            }
            if(stack.peek() == popA[i]){
                stack.pop();
            }else{
                return false;
            }
        }
        return true;
    }
}
