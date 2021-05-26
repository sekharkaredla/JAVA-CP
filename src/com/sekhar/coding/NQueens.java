package com.sekhar.coding;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    private List<List<String>> result = new ArrayList<>();
    private List<Integer> nQueensSolution = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        placeQueens(0, n);
        return result;
    }

    private void placeQueens(int placedQueens, int n) {
        if (placedQueens == n) {
            ArrayList<String> tempResult = new ArrayList<>();
            for (int i = 0; i < n; i++)
                tempResult.add("");
            for (int i = 0; i < n; i++) {
                StringBuilder temp = new StringBuilder(".".repeat(n));
                temp.setCharAt(i, 'Q');
                tempResult.set(nQueensSolution.get(i), temp.toString());
            }
            result.add(tempResult);
        }
        for (int currentQueen = 0; currentQueen < n; currentQueen++) {
            int j = 0;
            for (j = 0; j < placedQueens; j++) {
                int previousQueen = nQueensSolution.get(j);
                if (currentQueen == previousQueen || Math.abs(currentQueen - previousQueen) == Math.abs(placedQueens - j))
                    break;
            }
            if (j == placedQueens) {
                nQueensSolution.add(currentQueen);
                placeQueens(placedQueens + 1, n);
                nQueensSolution.remove(nQueensSolution.size() - 1);
            }
        }
    }
}
