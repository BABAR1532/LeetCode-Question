import java.util.ArrayList;

class Solution {

    public static boolean dfs(
        ArrayList<ArrayList<Integer>> adj, // This acts just like vector<int> adj[] in C++
        int node,
        boolean[] visited,
        int parent
    ) {
        visited[node] = true;

        // NOW you can iterate directly just like you do in C++!
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(adj, neighbor, visited, node)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    public boolean isCycle(int V, int[][] edges) {
        // Because Java gives us raw edges, we must manually build the C++ style 'adj' structure first
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (boolean i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Populating our adjacency list
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(adj, i, visited, -1)) {
                    return true;
                }
            }
        }

        return false;
    }
}
