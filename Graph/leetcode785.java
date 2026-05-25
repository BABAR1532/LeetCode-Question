class Solution {

    public static boolean bfs(
        int[][] graph,
        int node,
        int[] color,
        int currentColor
    ) {
        Queue<Integer> q = new LinkedList<>();

        color[node] = currentColor;

        q.add(node);

        while (!q.isEmpty()) {
            int value = q.poll();

            currentColor = 1 - color[value];

            for (int i : graph[value]) {
                if (color[i] == -1) {
                    color[i] = currentColor;
                    q.add(i);
                } else if (color[i] != currentColor) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int V = graph.length;

        int[] color = new int[V];

        Arrays.fill(color, -1);

        int currentColor = 0;

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!bfs(graph, i, color, currentColor)) {
                    return false;
                }
            }
        }

        return true;
    }
}

/// DFS soln
//

class Solution {

    public boolean dfs(
        ArrayList<ArrayList<Integer>> lists,
        int node,
        int currentColor,
        int[] color
    ) {
        color[node] = currentColor;

        for (int value : lists.get(node)) {
            if (color[value] == -1) {
                int curr = 1 - currentColor;

                if (!dfs(lists, value, curr, color)) {
                    return false;
                }
            } else if (color[value] == currentColor) {
                return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            lists.add(new ArrayList<>());
        }

        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int[] edge : edges) {
            lists.get(edge[0]).add(edge[1]);
        }

        int currentColor = 0;

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!dfs(lists, i, currentColor, color)) {
                    return false;
                }
            }
        }

        return true;
    }
}
