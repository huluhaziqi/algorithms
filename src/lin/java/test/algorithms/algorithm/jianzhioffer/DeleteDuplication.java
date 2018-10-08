package lin.java.test.algorithms.algorithm.jianzhioffer;

public class DeleteDuplication {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //1,2,3,3,4,4,5
        ListNode node = new ListNode(1);
        node.next= new ListNode(2);
        node.next.next= new ListNode(3);
        node.next.next.next= new ListNode(3);
        node.next.next.next.next= new ListNode(4);
        node.next.next.next.next.next= new ListNode(4);
        node.next.next.next.next.next.next= new ListNode(5);
        solution.deleteDuplication(node);
    }
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public static class Solution {
        public ListNode deleteDuplication(ListNode pHead)
        {
            if(pHead == null || pHead.next == null){
                return pHead;
            }
            ListNode head = new ListNode(0);
            head.next = pHead;
            ListNode p = pHead;
            ListNode pre = head;
            while(p != null){
                ListNode next = p.next;
                ListNode pNext = next;
                while(next != null && p.val == next.val){
                    next = next.next;
                }
                if(pNext != next){
                    if(p == pHead){
                        pre.next = next;
                        pHead = next;
                        p = pHead;
                    }else{
                        pre.next = next;
                        p = next;
                    }
                }else{
                    pre = p;
                    p = next;
                }
            }
            return head.next;
        }
    }
}
