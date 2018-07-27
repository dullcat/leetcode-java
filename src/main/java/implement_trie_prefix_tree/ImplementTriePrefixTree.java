package implement_trie_prefix_tree;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ImplementTriePrefixTree {
//    Implement a trie with insert, search, and startsWith methods.
//
//    Example:
//
//        Trie trie = new Trie();
//
//        trie.insert("apple");
//        trie.search("apple");   // returns true
//        trie.search("app");     // returns false
//        trie.startsWith("app"); // returns true
//        trie.insert("app");
//        trie.search("app");     // returns true
//    Note:
//
//    You may assume that all inputs are consist of lowercase letters a-z.
//    All inputs are guaranteed to be non-empty strings.

    // Insert your Solution class here
    class Trie {
        class Node {
            char c;
            boolean isLeaf;
            Map<Character, Node> children;
            public Node(char c) {
                this.c = c;
                this.isLeaf = false;
                children = new HashMap<>();
            }
        }

        Node root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new Node('#');
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node cur = root;
            for (char c: word.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    cur.children.put(c, new Node(c));
                }
                cur = cur.children.get(c);
            }
            cur.isLeaf = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node cur = root;
            for (char c: word.toCharArray()) {
                if (cur.children.containsKey(c)) {
                    cur = cur.children.get(c);
                }
                else
                    return false;
            }
            return cur.isLeaf;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node cur = root;
            for (char c: prefix.toCharArray()) {
                if (cur.children.containsKey(c)) {
                    cur = cur.children.get(c);
                }
                else
                    return false;
            }

            return cur.isLeaf || cur.children.size() > 0;
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
    public static class UnitTest {
        @Test
        public void testImplementTriePrefixTree() {
            //Solution s = new ImplementTriePrefixTree().new Solution();
        }
    }
}

