import java.util.PriorityQueue;

class Solution {

    class Pair {

        int dist;
        int node;

        Pair(int dist, int node) {
            this.dist = dist;
            this.node = node;
        }
    }

    public int spanningTree(int V, int[][] edges) {
        ArrayList<ArrayList<Pair>> lists = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            lists.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            int cost = edge[2];

            lists.get(src).add(new Pair(cost, dst));
            lists.get(dst).add(new Pair(cost, src));
        }

        boolean[] isMst = new boolean[V];

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        q.offer(new Pair(0, 0));

        int cost = 0;

        while (!q.isEmpty()) {
            Pair value = q.poll();

            int curCost = value.dist;
            int node = value.node;

            if (isMst[node]) continue;

            cost += curCost;

            isMst[node] = true;

            for (Pair p : lists.get(node)) {
                if (!isMst[p.node]) {
                    q.offer(new Pair(p.dist, p.node));
                }
            }
        }

        return cost;
    }
}
