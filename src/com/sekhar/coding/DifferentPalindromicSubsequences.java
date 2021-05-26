package com.sekhar.coding;

import java.util.HashSet;
import java.util.Set;

public class DifferentPalindromicSubsequences {
    private Set<String> palindromes = new HashSet<>();
    public int countPalindromicSubsequences(String S) {
        recursivelyBuildPalindromes(S, new StringBuilder(), 0, S.length());
        return palindromes.size() % 1_000_000_007;
    }

    private void recursivelyBuildPalindromes(String S, StringBuilder sb, int pos, int totalLength) {
        if (palindromes.contains(sb.toString()))
            return;
        if (isPalindrome(sb))
            palindromes.add(sb.toString());
        for (int i = pos; i < totalLength; i++) {
            sb.append(S.charAt(i));
            recursivelyBuildPalindromes(S, sb, i + 1, totalLength);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    private boolean isPalindrome(StringBuilder sb) {
        if (sb.length() == 0)
            return false;
        if (sb.length() == 1)
            return true;
        for (int i = 0; i < sb.length() / 2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length() - i - 1))
                return false;
        }
        return true;
    }
}
