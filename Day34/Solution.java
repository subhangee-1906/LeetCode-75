package Day34;

import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Build the graph
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
            double val = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, val);
            graph.get(b).put(a, 1.0 / val);
        }

        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String start = query.get(0);
            String end = query.get(1);
            results[i] = dfs(graph, start, end, new HashSet<>());
        }
        return results;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String current, String target, Set<String> visited) {
        if (!graph.containsKey(current) || !graph.containsKey(target)) return -1.0;
        if (current.equals(target)) return 1.0;
        visited.add(current);

        for (Map.Entry<String, Double> neighbor : graph.get(current).entrySet()) {
            if (visited.contains(neighbor.getKey())) continue;
            double product = dfs(graph, neighbor.getKey(), target, visited);
            if (product != -1.0) {
                return neighbor.getValue() * product;
            }
        }
        return -1.0;
    }
}
