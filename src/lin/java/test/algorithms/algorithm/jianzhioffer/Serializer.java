package lin.java.test.algorithms.algorithm.jianzhioffer;

public class Serializer {

    public static void main(String[] args) {
        Solution.TreeNode root = new Solution.TreeNode(8);
        root.left = new Solution.TreeNode(6);
        root.right = new Solution.TreeNode(10);
        root.left.left = new Solution.TreeNode(5);
        root.left.right = new Solution.TreeNode(7);
        root.right.left = new Solution.TreeNode(9);
        root.right.right = new Solution.TreeNode(11);
        Solution solution = new Solution();
       String str =  solution.Serialize(root);
        System.out.println(str);
        solution.Deserialize(str);
    }

    public static class Solution {
        public static class TreeNode {
            int val = 0;
            Solution.TreeNode left = null;
            Solution.TreeNode right = null;

            public TreeNode(int val) {
                this.val = val;

            }
        }
        String Serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            if(root == null){
                sb.append("#,");
                return sb.toString();
            }
            sb.append(root.val + ",");
            String left = Serialize(root.left);
            String right = Serialize(root.right);
            sb.append(left);
            sb.append(right);
            return sb.toString();
        }
        int index = -1;
        TreeNode Deserialize(String str) {
            index++;
            String[] tem = str.split(",");
            TreeNode node = null;
            if(!tem[index].equals("#")){
                node = new TreeNode(Integer.valueOf(tem[index]));
                node.left = Deserialize(str);
                node.right = Deserialize(str);
            }
            return node;
        }

    }
}
