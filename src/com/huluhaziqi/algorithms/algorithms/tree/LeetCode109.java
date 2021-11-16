package com.huluhaziqi.algorithms.algorithms.tree;

public class LeetCode109 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            if (head == null) {
                return null;
            }
            if (head.next == null) return new TreeNode(head.val);
            ListNode preMid = preMid(head);
            ListNode mid = preMid.next;
            preMid.next = null;
            TreeNode root = new TreeNode(mid.val);
            root.left = sortedListToBST(head);
            root.right = sortedListToBST(mid.next);
            return root;
        }

        ListNode preMid(ListNode head) {
            ListNode slow = head;
            ListNode pre = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            return pre;
        }
    }

    class Solution2 {
        public TreeNode sortedListToBST(ListNode head) {
            if(head == null){
                return null;
            }
            TreeNode root = buildTree(head,null);
            return root;
        }
        public TreeNode buildTree(ListNode head, ListNode right){
            if(head == right){
                return null;
            }
            ListNode min = getmin(head, right);
            TreeNode root = new TreeNode(min.val);
            root.left = buildTree(head, min);
            root.right = buildTree(min.next, right);
            return root;
        }
        public ListNode getmin(ListNode head,  ListNode e){
            if(head == null){
                return null;
            }
            if(head.next == null){
                return head;
            }
            ListNode first = head;
            ListNode second = head;
            while(second != e && second.next != e ){
                first = first.next;
                second = second.next.next;
            }
            return first;
        }
    }

    class Solution3 {
        public TreeNode sortedListToBST(ListNode head) {
            if(head == null){
                return null;
            }
            TreeNode root = buildTree(head);
            return root;
        }
        public TreeNode buildTree(ListNode head){
            if(head == null){
                return null;
            }
            if(head.next == null){
                return new TreeNode(head.val);
            }
            ListNode pre = getmin(head);
            ListNode mid = pre.next;
            TreeNode root = new TreeNode(mid.val);
            pre.next = null;
            root.left = buildTree(head);
            root.right = buildTree(mid.next);

            return root;
        }
        public ListNode getmin(ListNode head){
            if(head == null){
                return null;
            }
            ListNode pre = head;
            ListNode first = head;
            ListNode second = head;
            while(second !=null  && second.next != null ){
                pre = first;
                first = first.next;
                second = second.next.next;
            }
            return pre;
        }
    }
}
