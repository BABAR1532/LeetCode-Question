class Solution {

    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here

        int ans[] = new int[V];

        // Source value will always 0
        Arrays.fill(ans, (int) 1e8);

        ans[src] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int dist = edge[2];

                if (ans[u] != (int) 1e8 && ans[u] + dist < ans[v]) {
                    ans[v] = ans[u] + dist;
                }
            }
        }

        // if cyle

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int dist = edge[2];

            if (ans[u] != (int) 1e8 && ans[u] + dist < ans[v]) {
                return new int[] { -1 };
            }
        }

        return ans;
    }
}
