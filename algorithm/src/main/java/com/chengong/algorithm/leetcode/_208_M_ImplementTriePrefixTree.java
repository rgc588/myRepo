package com.chengong.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by cheng on 5/11/2017.
 */
public class _208_M_ImplementTriePrefixTree {
    public boolean isWord = false;
    public Map<Character, _208_M_ImplementTriePrefixTree> map = new HashMap<>();

    /** Initialize your data structure here. */
    public _208_M_ImplementTriePrefixTree() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        helper(this, word, 0);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return helper(this, word, 0, false);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return helper(this, prefix, 0, true);
    }

    private boolean helper(_208_M_ImplementTriePrefixTree t, String word, int i, boolean prefix) {
        if (i == word.length()) {
            return prefix || t.isWord;
        }
        char c = word.charAt(i);
        if (!t.map.containsKey(c)) return false;
        return helper(t.map.get(c), word, i+1, prefix);
    }

    private void helper(_208_M_ImplementTriePrefixTree t, String word, int i) {
        if (i == word.length()) {
            t.isWord = true;
            return;
        }
        char c = word.charAt(i);
        if (!t.map.containsKey(c)) {
            _208_M_ImplementTriePrefixTree tmp = new _208_M_ImplementTriePrefixTree();
            t.map.put(c, tmp);
        }
        helper(t.map.get(c), word, i+1);
    }
}
