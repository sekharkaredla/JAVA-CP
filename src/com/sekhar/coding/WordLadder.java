package com.sekhar.coding;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> allComboDict = new HashMap<>();

        int L = beginWord.length();

        // form the all combo dict
        wordList.forEach(eachWord -> {
            for (int i = 0; i < L; i++) {
                String newWordPattern = eachWord.substring(0, i) + '*' + eachWord.substring(i + 1);
                List<String> patternWords = allComboDict.getOrDefault(newWordPattern, new ArrayList<>());
                patternWords.add(eachWord);
                allComboDict.put(newWordPattern, patternWords);
            }
        });

        // queue for BFS
        LinkedList<Pair<String, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(beginWord, 1));

        // visited to escape cycles
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.removeFirst();
            String currentWord = node.getKey();
            int position = node.getValue();
            for (int i = 0; i < L; i++) {
                String newPattern = currentWord.substring(0, i) + '*' + currentWord.substring(i + 1);
                for (String adjacentWord : allComboDict.getOrDefault(newPattern, new ArrayList<>())) {
                    if (adjacentWord.equals(endWord))
                        return position + 1;
                    if (!visited.contains(adjacentWord)) {
                        visited.add(adjacentWord);
                        queue.addLast(new Pair<>(adjacentWord, position + 1));
                    }
                }
            }
        }
        return 0;
    }

}
