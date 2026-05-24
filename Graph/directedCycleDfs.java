class Solution {

    public boolean dfs(
        ArrayList<ArrayList<Integer>> lists,
        int node,
        boolean[] visited,
        boolean[] currentVisited
    ) {
        visited[node] = true;
        currentVisited[node] = true;

        for (int value : lists.get(node)) {
            if (!visited[value]) {
                if (dfs(lists, value, visited, currentVisited)) {
                    return true;
                }
            } else if (currentVisited[value]) {
                return true;
            }
        }

        currentVisited[node] = false;
        return false;
    }

    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            lists.add(new ArrayList<>());
        }

        boolean visited[] = new boolean[V];
        boolean[] currentVisited = new boolean[V];

        // Creting adjacency lists
        for (int[] list : edges) {
            lists.get(list[0]).add(list[1]);
        }

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(lists, i, visited, currentVisited)) {
                    return true;
                }
            }
        }

        return false;
    }
}
