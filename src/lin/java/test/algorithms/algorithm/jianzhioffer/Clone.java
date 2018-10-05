package lin.java.test.algorithms.algorithm.jianzhioffer;

public class Clone {

    public static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.next.next.next = new RandomListNode(4);
        head.next.next.next.next = new RandomListNode(5);
        RandomListNode result = Clone1(head);

    }

    public static RandomListNode Clone1(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode temp = pHead;
        while (temp != null) {
            RandomListNode node = new RandomListNode(temp.label);
            RandomListNode next = temp.next;
            node.next = next;
            temp.next = node;
            if(next == null){
                break;
            }
            temp = next;
        }
        temp = pHead;
        while(temp != null){
            RandomListNode next = temp.next;
            next.random = temp.random;
            temp = next.next;
        }
        temp = pHead;
        RandomListNode cloneHead = pHead.next;
        while(temp != null){
            RandomListNode nextNext = temp.next != null ? temp.next.next : null;
            RandomListNode next = temp.next;
            temp.next = nextNext;
            temp = next;
        }
        return cloneHead;
    }

    public class Solution {
        public RandomListNode Clone(RandomListNode pHead) {

            RandomListNode temp = pHead;
            while (temp != null) {
                RandomListNode node = new RandomListNode(temp.label);
                RandomListNode next = temp.next;
                node.next = next;
                temp.next = node;
                temp = next;
            }
            temp = pHead;
            while(temp != null){
                RandomListNode next = temp.next;
                next.random = temp.random == null ? null : temp.random;
                temp = next.next;
            }
            temp = pHead;
            RandomListNode cloneHead = pHead.next;
            while(temp != null){
                RandomListNode nextNext = temp.next != null ? temp.next.next : null;
                RandomListNode next = temp.next;
                temp.next = nextNext;
                temp = next;
            }
            return cloneHead;
        }
    }


    public class Solution2 {
        public RandomListNode Clone(RandomListNode pHead) {
            if(pHead == null) {
                return null;
            }

            RandomListNode currentNode = pHead;
            //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
            while(currentNode != null){
                RandomListNode cloneNode = new RandomListNode(currentNode.label);
                RandomListNode nextNode = currentNode.next;
                currentNode.next = cloneNode;
                cloneNode.next = nextNode;
                currentNode = nextNode;
            }

            currentNode = pHead;
            //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
            while(currentNode != null) {
                currentNode.next.random = currentNode.random==null?null:currentNode.random.next;
                currentNode = currentNode.next.next;
            }

            //3、拆分链表，将链表拆分为原链表和复制后的链表
            currentNode = pHead;
            RandomListNode pCloneHead = pHead.next;
            while(currentNode != null) {
                RandomListNode cloneNode = currentNode.next;
                currentNode.next = cloneNode.next;
                cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
                currentNode = currentNode.next;
            }

            return pCloneHead;
        }
    }
}
