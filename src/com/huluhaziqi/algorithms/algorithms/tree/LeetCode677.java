package com.huluhaziqi.algorithms.algorithms.tree;

import java.util.HashMap;
import java.util.Map;

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

        /**
         * Initialize your data structure here.
         */
        public MapSum2() {

        }

        public void insert(String key, int val) {
            if (key == null || key.length() == 0) {
                return;
            }
            insert(key, root, val);
        }

        public void insert(String key, Node node, int val) {
            if (node == null) return;
            if (key.length() == 0) {
                node.val = val;
                return;
            }
            int tem = key.charAt(0) - 'a';
            Node child = node.child[tem];
            if (child == null) {
                child = new Node();
            }
            insert(key.substring(1), child, val);
        }

        public int sum(String prefix) {
            return sum(prefix, root);
        }

        int sum(String prefix, Node node) {
            if (node == null) {
                return 0;
            }
            if (prefix.length() != 0) {
                int tem = prefix.charAt(0) - 'a';
                Node child = node.child[tem];
                return sum(prefix.substring(1), child);
            }
            int sum = node.val;
            for (Node c : node.child) {
                sum += sum(prefix, c);
            }
            return sum;
        }

    }

    class MapSum3 {
        Map<String, Integer> map = new HashMap<>();

        /**
         * Initialize your data structure here.
         */
        public MapSum3() {

        }

        public void insert(String key, int val) {
            map.put(key, val);
        }

        public int sum(String prefix) {
            int sum = 0;
            for (String str : map.keySet()) {
                if (str.startsWith(prefix)) {
                    sum += map.get(str);
                }
            }

            return sum;
        }
    }

    class MapSum5 {
        private class Node {
            Node[] child = new Node[26];
            int val;
            boolean isLeaf;
        }

        private Node root = new Node();

        /**
         * Initialize your data structure here.
         */
        public MapSum5() {

        }

        public void insert(String key, int val) {
            if (key == null || key.length() == 0) {
                return;
            }
            insert(key, root, val);
        }

        public void insert(String key, Node node, int val) {
            if (node == null) return;
            if (key.length() == 0) {
                node.val = val;
                return;
            }
            int tem = key.charAt(0) - 'a';
            if (node.child[tem] == null) {
                node.child[tem] = new Node();
            }
            insert(key.substring(1), node.child[tem], val);
        }

        public int sum(String prefix) {
            if (prefix == null || prefix.length() == 0) {
                return 0;
            }
            Node node = root;
            for (int i = 0; i < prefix.length(); i++) {
                int tem = prefix.charAt(i) - 'a';
                if (node.child[tem] == null) {
                    return 0;
                }
                node = node.child[tem];
            }
            return sum(node);
        }

        int sum(Node node) {
            if (node == null) {
                return 0;
            }
            int sum = node.val;
            for (Node c : node.child) {
                sum += sum(c);
            }
            return sum;
        }

    }

    class MapSum4 {
        private class Node {
            Node[] child = new Node[26];
            int val;
            boolean isLeaf;
        }

        private Node root = new Node();

        /**
         * Initialize your data structure here.
         */
        public MapSum4() {

        }

        public void insert(String key, int val) {
            if (key == null || key.length() == 0) {
                return;
            }
            insert(key, root, val);
        }

        public void insert(String key, Node node, int val) {
            if (node == null) return;
            if (key.length() == 0) {
                node.val = val;
                return;
            }
            int tem = key.charAt(0) - 'a';
            if (node.child[tem] == null) {
                node.child[tem] = new Node();
            }
            insert(key.substring(1), node.child[tem], val);
        }

        public int sum(String prefix) {
            if (prefix == null || prefix.length() == 0) {
                return 0;
            }
            Node node = root;
            for (int i = 0; i < prefix.length(); i++) {
                int tem = prefix.charAt(i) - 'a';
                if (node.child[tem] == null) {
                    return 0;
                }
                node = node.child[tem];
            }
            return sum(node);
        }

        int sum(Node node) {
            if (node == null) {
                return 0;
            }
            int sum = node.val;
            for (Node c : node.child) {
                sum += sum(c);
            }
            return sum;
        }

    }

    class MapSum5 {
        private class Node {
            Node[] childs = new Node[26];
            boolean isLeaf = false;
            int val = 0;
        }

        private Node root = new Node();

        Map<String, Integer> map = new HashMap<>();

        public MapSum5() {

        }

        public void insert(String key, int val) {
            map.put(key, val);
            insert(key, root, val);
        }

        private void insert(String key, Node node, int val) {
            if (node == null) {
                return;
            }
            if (key.length() == 0) {
                node.isLeaf = true;
                node.val = val;
                return;
            }
            int v = key.charAt(0) - 'a';
            if (node.childs[v] == null) {
                node.childs[v] = new Node();
            }
            insert(key.substring(1), node.childs[v], val);
        }

        public int sum(String prefix) {
            return sum(prefix, root);
        }

        public int sum(String prefix, Node node) {
            if (node == null) {
                return 0;
            }
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (node.childs[index] == null) {
                    return 0;
                }
                node = node.childs[index];
            }
            return dfs(node);
        }

        int dfs(Node node) {
            if (node == null) {
                return 0;
            }
            int sum = 0;
            if (node.val > 0) {
                sum += node.val;
            }
            for (Node child : node.childs) {
                sum += dfs(child);
            }
            return sum;
        }

    }

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
}
