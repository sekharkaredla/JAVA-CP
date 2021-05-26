package com.sekhar.coding;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public Map<Character, TrieNode> map;
    public boolean isWord;
    public TrieNode(){
        map = new HashMap<>();
        isWord = false;
    }
}

