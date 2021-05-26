package com.sekhar.coding;

import java.util.ArrayList;

public class UnionFind {

    //Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] parent = new int[V];
        for (int i = 0; i < V; i++)
            parent[i] = -1;

        for (int i = 0; i < V; i++) {
            for (int eachEdge : adj.get(i)) {
                int x = findRootParent(parent, i);
                int y = findRootParent(parent, eachEdge);
                if (x == y)
                    return true;
                attachParent(parent, x, y);
            }
        }
        return false;
    }

    private int findRootParent(int[] parent, int i) {
        if (parent[i] == -1)
            return i;
        return findRootParent(parent, parent[i]);
    }

    private void attachParent(int[] parent, int x, int y) {
        parent[x] = y;
    }
}
