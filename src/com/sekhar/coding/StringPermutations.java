package com.sekhar.coding;

import java.util.LinkedList;
import java.util.List;

public class StringPermutations {

    private List<String> permutations = new LinkedList<>();

    public List<String> getPermutations(String s) {
        generatePermutations(s, new StringBuilder());
        return permutations;
    }

    private void generatePermutations(String s, StringBuilder result) {
        if (s.length() == 0) {
            permutations.add(result.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            result.append(s.charAt(i));
            generatePermutations(s.substring(0, i) + s.substring(i + 1), result);
            result.deleteCharAt(result.length() - 1);
        }
    }
}
