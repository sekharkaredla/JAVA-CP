package com.sekhar.coding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TopologicalSortPossibleOrNot {
    private boolean[] visited;
    private Map<Integer, Integer> positions = new HashMap<>();
    private ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private Stack<Integer> stack = new Stack<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++)
            graph.add(new ArrayList<Integer>());
        for (int i = 0; i < prerequisites.length; i++)
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        for (int i = 0; i < numCourses; i++)
            if (!visited[i])
                dfs(i);
        return !checkForCycle(numCourses);
    }

    private void dfs(int vertex) {
        visited[vertex] = true;
        for (int eachAdjacentVertex : graph.get(vertex))
            if (!visited[eachAdjacentVertex])
                dfs(eachAdjacentVertex);
        stack.push(vertex);
    }

    private boolean checkForCycle(int numCourses) {
        int index = 0;
        while (!stack.empty())
            positions.put(stack.pop(), index++);

        for (int i = 0; i < numCourses; i++) {
            for (int eachAdjacentVertex : graph.get(i))
                if (positions.get(i) > positions.get(eachAdjacentVertex))
                    return true;
        }
        return false;
    }
}
