package lin.java.test.algorithms.algorithm.jianzhioffer;

public class GetNextTree {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public class Solution {
        public TreeLinkNode GetNext(TreeLinkNode pNode) {
            if (pNode.right != null) {
                TreeLinkNode node = pNode.right;
                while (node.left != null) {
                    node = node.left;
                }
                return node;
            } else {
                while (pNode.next != null) {
                    TreeLinkNode parent = pNode.next;
                    if (parent.left != pNode) {
                        pNode = parent;
                    } else {
                        return parent;
                    }
                }
            }
            return null;
        }
    }
}
