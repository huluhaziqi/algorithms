package com.huluhaziqi.algorithms.algorithms.algorithm.jianzhioffer;

public class FindFirstCommonNode {

    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            if (pHead1 == null || pHead2 == null) {
                return null;
            }
            ListNode firstNode = null;
            while (pHead1 != null) {
                ListNode node = pHead2;
                while (node != null) {
                    if (node == pHead1) {
                        return node;
                    } else {
                        node = node.next;
                    }
                }
                pHead1 = pHead1.next;
            }
            return firstNode;
        }
    }

    public class Solution2 {
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            if (pHead1 == null || pHead2 == null) {
                return null;
            }
            int len1 = 0;
            int len2 = 0;
            ListNode tem1 = pHead1;
            ListNode tem2 = pHead2;
            while (tem1 != null) {
                tem1 = tem1.next;
                len1++;
            }
            while (tem2 != null) {
                tem2 = tem2.next;
                len2++;
            }
            ListNode firstCommonNode = null;
            while (len1 > len2) {
                pHead1 = pHead1.next;
                len1--;
            }
            while (len2 > len1) {
                pHead2 = pHead2.next;
                len1--;
            }
            while (pHead1 != null) {
                if (pHead1 == pHead2) {
                    return pHead1;
                } else {
                    pHead1 = pHead1.next;
                    pHead2 = pHead2.next;
                }
            }
            return firstCommonNode;
        }
    }
}
