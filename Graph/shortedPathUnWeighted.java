class Solution {

    class Pair {

        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            lists.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            lists.get(edge[0]).add(edge[1]);
            lists.get(edge[1]).add(edge[0]);
        }

        int[] ans = new int[V];
        Arrays.fill(ans, -1);

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(src, 0));

        ans[src] = 0;

        while (!q.isEmpty()) {
            Pair node = q.poll();

            for (int value : lists.get(node.node)) {
                if (ans[value] == -1) {
                    int nextDistance = node.dist + 1;
                    ans[value] = nextDistance;
                    q.add(new Pair(value, nextDistance));
                }
            }
        }

        return ans;
    }
}
