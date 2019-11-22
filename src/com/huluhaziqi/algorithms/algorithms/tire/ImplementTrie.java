package com.huluhaziqi.algorithms.algorithms.tire;

public class ImplementTrie {

    public static void main(String[] args) {
    }
    class Trie {

        class Node{
            Node[] child = new Node[26];
            boolean isLeaf;
        }
        private Node root = new Node();
        /** Initialize your data structure here. */
        public Trie() {
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            insert(word,root);
        }
        private void insert(String word,Node node){
            if(node == null){
                return;
            }
            if(word.length() == 0){
                node.isLeaf = true;
                return;
            }
            int index = indexForChar(word.charAt(0));
            if(node.child[index] == null){
                node.child[index] = new Node();
            }
            insert(word.substring(1),node.child[index]);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            return search(word,root);
        }

        private boolean search(String word, Node node){
            if(node == null){
                return false;
            }
            if(word.length() == 0){
                return node.isLeaf;
            }
            int index = indexForChar(word.charAt(0));
            return search(word.substring(1),node.child[index]);
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return startsWith(prefix,root);
        }
        private boolean startsWith(String word, Node node){
            if(node == null){
                return false;
            }
            if(word.length() == 0) return true;
            int index = indexForChar(word.charAt(0));
            return startsWith(word.substring(1),node.child[index]);
        }

        private int indexForChar(char x){
            return x - 'a';
        }
    }

}
