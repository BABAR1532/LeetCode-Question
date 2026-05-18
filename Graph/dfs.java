class Solution {

    public static void dfs(
        ArrayList<ArrayList<Integer>> adj,
        int node,
        boolean[] visited,
        ArrayList<Integer> dfsArray
    ) {
        // Base case
        if (visited[node] == true) return;

        visited[node] = true;
        dfsArray.add(node);

        for (int i : adj.get(node)) {
            if (!visited[i]) {
                dfs(adj, i, visited, dfsArray);
            }
        }
    }

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int size = adj.size() - 1;

        boolean[] visited = new boolean[size];

        Arrays.fill(visited, false);

        ArrayList<Integer> dfsArray = new ArrayList<>();

        dfs(adj, 0, visited, dfsArray);

        return dfsArray;
    }
}
