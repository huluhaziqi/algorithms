package lin.java.test.algorithms.algorithm.jianzhioffer;

public class EntryNodeOfLoop {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;
        solution.EntryNodeOfLoop(node1);
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static class Solution {

        public ListNode EntryNodeOfLoop(ListNode pHead)
        {
            if(pHead == null || pHead.next == null){
                return null;
            }
            ListNode common = getCommon(pHead);
            if(common == null){
                return common;
            }
            int count = 0;
            ListNode temCommon = common;
            while(temCommon.next != common){
                temCommon = temCommon.next;
                count++;
            }
            ListNode p1 = pHead;
            ListNode p2 = pHead;
            for(int i = 0; i < count; i++){
                p1 = p1.next;
            }
            while(p1 != p2){
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        }

        public ListNode getCommon(ListNode pHead){
            ListNode p1 = pHead;
            ListNode p2 = pHead.next;
            if(p2 == null){
                return null;
            }
            while(p1 != null&& p2 != null){
                if(p1 == p2){
                    return p1;
                }
                p1 = p1.next;
                p2 = p2.next;
                if(p2.next != null){
                    p2 = p2.next;
                }
            }
            return null;
        }
    }
}
