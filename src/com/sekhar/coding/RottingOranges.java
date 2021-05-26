package com.sekhar.coding;

import java.util.Arrays;
import java.util.LinkedList;

public class RottingOranges {
    private LinkedList<OrangePosition> queue = new LinkedList<>();
    public int orangesRotting(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    queue.add(new OrangePosition(i ,j, 1));
            }
        }
        passMinute(grid);
        int min = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return -1;
                if (min > grid[i][j])
                    min = grid[i][j];
            }
        }
        return -1 * (min + 1);
    }
    private void passMinute(int[][] grid) {
        while (!queue.isEmpty()) {
            OrangePosition pos = queue.removeFirst();
            int x = pos.x;
            int y = pos.y;
            int minute = pos.minute;
            if (grid[x][y] == 1)
                grid[x][y] = -1 * minute;
            if ((x - 1) >= 0 && grid[x - 1][y] == 1)
                queue.addLast(new OrangePosition(x - 1, y, minute + 1));
            if ((y - 1) >= 0 && grid[x][y - 1] == 1)
                queue.addLast(new OrangePosition(x, y - 1, minute + 1));
            if ((x + 1) < grid.length && grid[x + 1][y] == 1)
                queue.addLast(new OrangePosition(x + 1, y, minute + 1));
            if ((y + 1) < grid[0].length && grid[x][y + 1] == 1)
                queue.addLast(new OrangePosition(x, y + 1, minute + 1));
        }
    }
}
