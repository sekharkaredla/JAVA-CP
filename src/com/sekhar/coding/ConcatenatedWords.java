package com.sekhar.coding;

import java.util.LinkedList;
import java.util.List;

public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        TrieNode root = new TrieNode();
        for (String each : words) {
            TrieNode head = root;
            for (char c : each.toCharArray()) {
                if (!head.map.containsKey(c))
                    head.map.put(c, new TrieNode());
                head = head.map.get(c);
            }
            head.isWord = true;
        }
        return searchWordsInTrie(root, words);
    }
    private List<String> searchWordsInTrie(TrieNode root, String[] words) {
        List<String> result = new LinkedList<>();
        for(String word : words)
            if (concatWordOrNot(root, word, false))
                result.add(word);
        return result;
    }
    private boolean concatWordOrNot(TrieNode root, String word, boolean isSubstring) {
        // original words can be only added to result, if they are completely built by 2 or more words
        //
        TrieNode head = root;
        int index = 0;
        for (char c : word.toCharArray()) {
            if (!head.map.containsKey(c))
                return false;
            head = head.map.get(c);
            index++;
            if (head.isWord && index < word.length())
                if (concatWordOrNot(root, word.substring(index), true))
                    return true; // for original words
        }
        return head.isWord && isSubstring; // to check if substrings are words are not
    }

}
