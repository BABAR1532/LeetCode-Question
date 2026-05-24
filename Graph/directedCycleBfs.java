class Solution {

    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            lists.add(new ArrayList<>());
        }

        int[] indegree = new int[V];

        Arrays.fill(indegree, 0);

        // Adjacenty lists
        for (int[] edge : edges) {
            lists.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            for (int value : lists.get(node)) {
                indegree[value] = indegree[value] - 1;

                if (indegree[value] == 0) {
                    q.add(value);
                }
            }
        }

        if (V == count) return false;

        return true;
    }
}
