package com.sekhar.coding;

import java.util.ArrayList;

public class RatInAMaze {
    private ArrayList<String> result;

    public ArrayList<String> findPath(int[][] m) {
        result = new ArrayList<>();
        m[0][0] = 0;
        getPath(m, 0, 0, new StringBuilder());
        return result;
    }

    private void getPath(int[][] m, int x, int y, StringBuilder path) {
        if (x == m.length - 1 && y == m.length - 1) {
            result.add(path.toString());
            return;
        }
        if (x - 1 >= 0 && m[x - 1][y] == 1) {
            m[x - 1][y] = 0;
            path.append('U');
            getPath(m, x - 1, y, path);
            path.deleteCharAt(path.length() - 1);
            m[x - 1][y] = 1;
        }
        if (x + 1 < m.length && m[x + 1][y] == 1) {
            m[x + 1][y] = 0;
            path.append('D');
            getPath(m, x + 1, y, path);
            path.deleteCharAt(path.length() - 1);
            m[x + 1][y] = 1;
        }
        if (y - 1 >= 0 && m[x][y - 1] == 1) {
            m[x][y - 1] = 0;
            path.append('L');
            getPath(m, x, y - 1, path);
            path.deleteCharAt(path.length() - 1);
            m[x][y - 1] = 1;
        }
        if (y + 1 < m.length && m[x][y + 1] == 1) {
            m[x][y + 1] = 0;
            path.append('R');
            getPath(m, x, y + 1, path);
            path.deleteCharAt(path.length() - 1);
            m[x][y + 1] = 1;
        }
    }
}
