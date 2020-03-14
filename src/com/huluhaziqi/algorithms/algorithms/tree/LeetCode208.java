package com.huluhaziqi.algorithms.algorithms.tree;

public class LeetCode208 {


    class Trie {

        private class Node {
            private Node[] child = new Node[26];
            boolean isLeaf;
            private char c;

            public Node(char c) {
                this.c = c;
            }

            public Node() {
            }

        }

        private Node root = new Node();

        /**
         * Initialize your data structure here.
         */
        public Trie() {

        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            Node node = root;
            int index = 0;
            for (char c : word.toCharArray()) {
                int tem = c - 'a';
                if (node.child[tem] == null) {
                    node.child[tem] = new Node(c);
                }
                node = node.child[tem];
                if (index == word.length() - 1) {
                    node.isLeaf = true;
                }
                index++;

            }
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            if (word == null || word.length() == 0) {
                return true;
            }
            Node node = root;
            int index = 0;
            for (char c : word.toCharArray()) {
                int tem = c - 'a';
                if (node.child != null) {
                    if (node.child[tem] != null) {
                        if (node.child[tem].isLeaf && index == word.length() - 1) {
                            return true;
                        }
                        node = node.child[tem];
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
                index++;
            }
            return false;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            if (prefix == null || prefix.length() == 0) {
                return true;
            }
            Node node = root;
            int index = 0;
            for (char c : prefix.toCharArray()) {
                int tem = c - 'a';
                if (node.child != null) {
                    if (node.child[tem] != null) {
                        node = node.child[tem];
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
                index++;
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
