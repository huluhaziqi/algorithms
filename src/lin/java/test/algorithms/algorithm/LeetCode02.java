package lin.java.test.algorithms.algorithm;

import java.util.Scanner;

/**
 * [LeetCode] Add Two Numbers 两个数字相加
 */
public class LeetCode02 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String string1 = scanner.nextLine();
            String string2 = scanner.nextLine();
            String[] aString = string1.split(" ");
            String[] bString = string2.split(" ");
            Node list1 = new Node(0);
            Node cur1 = list1;
            for (int i = 0; i < aString.length; i++) {
                Node temp = new Node(Integer.parseInt(aString[i]));
                cur1.next = temp;
                cur1 = cur1.next;
            }
            Node list2 = new Node(0);
            Node cur2 = list2;
            for (int i = 0; i < bString.length; i++) {
                Node temp = new Node(Integer.parseInt(bString[i]));
                cur2.next = temp;
                cur2 = cur2.next;
            }
            Node result = sumTwo(list1.next, list2.next);
            while (result != null) {
                System.out.println(result.val);
                result = result.next;
            }
        }
    }

    public static Node sumTwo(Node list1, Node list2) {
        Node result = new Node(0);
        Node cur = result;
        int r = 0;
        Node start1 = list1;
        Node start2 = list2;
        while (start1 != null || start2 != null) {
            int val1 = (start1 == null) ? 0 : start1.val;
            int val2 = (start2 == null) ? 0 : start2.val;
            int sum = (r + val1 + val2) % 10;
            r = (r + val1 + val2) / 10;
            Node temp = new Node(sum);
            cur.next = temp;
            cur = cur.next;
            if (start1 != null) start1 = start1.next;
            if (start2 != null) start2 = start2.next;

        }
        if (r != 0) {
            Node node = new Node(r);
            cur.next = node;
        }
        return result.next;
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
