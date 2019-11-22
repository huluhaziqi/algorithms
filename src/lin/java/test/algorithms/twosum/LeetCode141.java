package lin.java.test.algorithms.twosum;

public class LeetCode141 {
    //    Given a linked list, determine if it has a cycle in it.
//
//    To represent a cycle in the given linked list, we use an integer pos which
//    represents the position (0-indexed) in the linked list where tail connects to.
//    If pos is -1, then there is no cycle in the linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode first = head;
            ListNode second = head.next;
            while (first != null && second != null) {
                first = first.next;
                if (second.next == null) {
                    return false;
                }
                second = second.next.next;
                if (second == first) {
                    return true;
                }
            }
            return false;
        }
    }
}
