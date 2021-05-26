package com.sekhar.coding;

import java.util.LinkedList;
import java.util.List;

public class StringSubStrings {

    private List<String> subStrings;

    public List<String> getSubStrings(String s) {
        subStrings = new LinkedList<>();
        generateSubStrings(s);
        return subStrings;
    }

    private void generateSubStrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                subStrings.add(s.substring(i, j));
            }
        }
    }
}
