package lin.java.test.algorithms.sort;

public class InsertSort {

    //    public static void main(String[] args) {
//        ListNode head = new ListNode(4);
//        head.next = (new ListNode(2));
//        head.next.next = (new ListNode(1));
//        head.next.next.next = (new ListNode(3));
//        ListNode result = new InsertSort().insertionSortList(head);
//        while (result != null) {
//            System.out.println(result.val);
//            result = result.next;
//        }
//
//    }
    public static void main(String[] args) {
        int[] array = {3, 4, 5, 7, 2, 1, 67, 8, 3, 4, 5, 0};
        new InsertSort().insertSort4(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            ListNode p = first.next;
            ListNode pre = first;
            while (p != null && p.val < cur.val) {
                pre = p;
                p = p.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = temp;
        }
        return first.next;
    }


    public void insertionSortList(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int index = 0;
            while (index < i && array[index] <= array[i]) {
                index++;
            }
            int tem = array[i];
            for (int j = i - 1; j >= index; j--) {
                array[j + 1] = array[j];
            }
            array[index] = tem;
        }
    }

    public void insertionSortList2(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int index = i - 1;
            int tem = array[i];
            while (index >= 0 && array[index] > tem) {
                array[index + 1] = array[index];
                index--;
            }
            array[index + 1] = tem;
        }
    }

    public void insertSort3(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int i = 1; i < array.length; i++) {
            int tem = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > tem) {
                    array[j + 1] = array[j];
                } else break;
            }
            array[j + 1] = tem;
        }
    }

    public void insertSort4(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int tem = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > tem) {
                    array[j + 1] = array[j];
                } else break;
            }
            array[j + 1] = tem;
        }
    }
}
