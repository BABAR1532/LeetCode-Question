class Solution {

    class Pair {

        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> lists = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            lists.add(new ArrayList<>());
        }

        int[] ans = new int[V];

        Arrays.fill(ans, Integer.MAX_VALUE);

        // Creating minHeap
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        for (int[] edge : edges) {
            // It is undirected graph
            lists.get(edge[0]).add(new Pair(edge[1], edge[2]));
            lists.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        minHeap.offer(new int[] { 0, src });
        ans[src] = 0;

        while (!minHeap.isEmpty()) {
            int edge[] = minHeap.poll();

            int cDist = edge[0];
            int cNode = edge[1];

            // if already processed with smaller value
            if (cDist > ans[cNode]) {
                continue;
            }

            for (Pair p : lists.get(cNode)) {
                int weight = cDist + p.dist;

                // Relaxation
                if (weight < ans[p.node]) {
                    ans[p.node] = weight;
                    minHeap.offer(new int[] { weight, p.node });
                }
            }
        }

        return ans;
    }
}
