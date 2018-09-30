package lin.java.test.algorithms.algorithm.jianzhioffer;

import java.util.ArrayList;
import java.util.Stack;

public class ReverseList {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (listNode != null) {
            result.add(0, listNode.val);
            listNode = listNode.next;
        }
        return result;
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public int NumberOf1(int n) {
        int result = 0;
        while(n > 0){
            if((n & 1) == 1){
                result++;
            }
            n >>>= 1;
        }
        return result;
    }

}
