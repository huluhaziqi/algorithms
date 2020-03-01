package com.huluhaziqi.algorithms.algorithms.twosum;

public class LeetCode141 {
    //    Given a linked list, determine if it has a cycle in it.
//
//    To represent a cycle in the given linked list, we use an integer pos which
//    represents the position (0-indexed) in the linked list where tail connects to.
//    If pos is -1, then there is no cycle in the linked list.

    /**
     * leetcode141
     * 141. Linked List Cycle
     * Easy
     * <p>
     * 2315
     * <p>
     * 351
     * <p>
     * Add to List
     * <p>
     * Share
     * Given a linked list, determine if it has a cycle in it.
     * <p>
     * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: head = [3,2,0,-4], pos = 1
     * Output: true
     * Explanation: There is a cycle in the linked list, where tail connects to the second node.
     * <p>
     * <p>
     * Example 2:
     * <p>
     * Input: head = [1,2], pos = 0
     * Output: true
     * Explanation: There is a cycle in the linked list, where tail connects to the first node.
     * <p>
     * <p>
     * Example 3:
     * <p>
     * Input: head = [1], pos = -1
     * Output: false
     * Explanation: There is no cycle in the linked list.
     * <p>
     * <p>
     * <p>
     * <p>
     * Follow up:
     * <p>
     * Can you solve it using O(1) (i.e. constant) memory?
     * <p>
     * Accepted
     * 544,405
     * Submissions
     * 1,373,403
     */
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

    public class Solution2 {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode first = head;
            ListNode next = head.next;
            while (first != null && next != null) {
                if (first == next) {
                    return true;
                }
                first = first.next;
                if (next.next != null) {
                    next = next.next.next;
                } else {
                    next = null;
                }
            }
            return false;
        }
    }
}
