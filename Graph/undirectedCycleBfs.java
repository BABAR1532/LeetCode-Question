class Solution {

    class Pair {

        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public boolean bfs(
        ArrayList<ArrayList<Integer>> lists,
        int node,
        boolean[] visited
    ) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, -1));

        visited[node] = true;

        while (!q.isEmpty()) {
            Pair p = q.remove();

            for (int i : lists.get(p.node)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(new Pair(i, p.node));
                } else if (i != p.parent) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            lists.add(new ArrayList<>());
        }

        // Making adjacent lists
        for (int[] l : edges) {
            lists.get(l[0]).add(l[1]);
            lists.get(l[1]).add(l[0]);
        }

        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (bfs(lists, i, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
