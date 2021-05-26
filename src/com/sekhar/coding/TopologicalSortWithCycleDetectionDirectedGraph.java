package com.sekhar.coding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TopologicalSortWithCycleDetectionDirectedGraph {
    private Stack<Integer> stack = new Stack<>();
    private boolean[] visited;
    Map<Integer, Integer> positionsOfCycleCheck = new HashMap<>();

    public ArrayList<Integer> topologicalSort(int V, ArrayList<ArrayList<Integer>> adj) {
        visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i])
            dfs(i, adj);
        }
        ArrayList<Integer> topologicalOrder = getTopologicalOrder();
        if (cycleExists(V, adj))
            return null;
        return topologicalOrder;
    }

    private void dfs(int vertex, ArrayList<ArrayList<Integer>> adj) {
        visited[vertex] = true;
        for (int eachAdjacentVertex : adj.get(vertex)) {
            if (!visited[eachAdjacentVertex])
                dfs(eachAdjacentVertex, adj);
        }
        stack.push(vertex);
    }

    private ArrayList<Integer> getTopologicalOrder() {
        ArrayList<Integer> topologicalOrder = new ArrayList<>();
        int index = 0;
        while (!stack.empty()) {
            positionsOfCycleCheck.put(stack.peek(), index++);
            topologicalOrder.add(stack.pop());
        }
        return topologicalOrder;
    }

    private boolean cycleExists(int V, ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < V; i++) {
            for (int eachAdjacentVertex : adj.get(i))
                if (positionsOfCycleCheck.get(i) > positionsOfCycleCheck.get(eachAdjacentVertex))
                    return true;
        }
        return false;
    }
}
