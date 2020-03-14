package com.huluhaziqi.algorithms.algorithms.tree;

public class LeetCode677 {
    class MapSum {

        private class Node {
            Node[] child = new Node[26];
            int value;
        }

        private Node root = new Node();

        public MapSum() {

        }

        public void insert(String key, int val) {
            insert(key, root, val);
        }

        private void insert(String key, Node node, int val) {
            if (node == null) return;
            if (key.length() == 0) {
                node.value = val;
                return;
            }
            int index = indexForChar(key.charAt(0));
            if (node.child[index] == null) {
                node.child[index] = new Node();
            }
            insert(key.substring(1), node.child[index], val);
        }

        public int sum(String prefix) {
            return sum(prefix, root);
        }

        private int sum(String prefix, Node node) {
            if (node == null) return 0;
            if (prefix.length() != 0) {
                int index = indexForChar(prefix.charAt(0));
                return sum(prefix.substring(1), node.child[index]);
            }
            int sum = node.value;
            for (Node child : node.child) {
                sum += sum(prefix, child);
            }
            return sum;
        }

        private int indexForChar(char c) {
            return c - 'a';
        }
    }

    class MapSum2 {
        private class Node {
            Node[] child = new Node[26];
            int val;
            boolean isLeaf;
        }

        private Node root = new Node();

        /** Initialize your data structure here. */
        public MapSum2() {

        }

        public void insert(String key, int val) {
            if(key == null || key.length() == 0){
                return;
            }
            insert(key, root, val);
        }
        public void insert(String key, Node node , int val){
            if(node == null) return;
            if(key.length() == 0){
                node.val = val;
                return;
            }
            int tem = key.charAt(0) - 'a';
            Node child = node.child[tem];
            if(child == null){
                child = new Node();
            }
            insert(key.substring(1), child, val);
        }

        public int sum(String prefix) {
            return sum(prefix, root);
        }

        int sum(String prefix, Node node){
            if(node == null){
                return 0;
            }
            if(prefix.length() != 0){
                int tem = prefix.charAt(0) - 'a';
                Node child = node.child[tem];
                return sum(prefix.substring(1), child);
            }
            int sum = node.val;
            for(Node c : node.child){
                sum += sum(prefix, c);
            }
            return sum;
        }

    }
}
