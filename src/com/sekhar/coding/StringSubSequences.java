package com.sekhar.coding;

import java.util.LinkedList;
import java.util.List;

public class StringSubSequences {
    private List<String> subSequences;

    public List<String> getSubSequences(String s) {
        subSequences = new LinkedList<>();
        generateSubStrings(s, new StringBuilder());
        return subSequences;
    }

    private void generateSubStrings(String s, StringBuilder result) {
        if (s.length() == 0)
            return;
        for (int i = 0; i < s.length(); i++) {
            result.append(s.charAt(i));
            subSequences.add(result.toString());
            generateSubStrings(s.substring(i + 1), result);
            result.deleteCharAt(result.length() - 1);
        }
    }
}
