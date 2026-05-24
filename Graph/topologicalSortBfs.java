class Solution {

    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            lists.add(new ArrayList<>());
        }

        int[] indegree = new int[V];

        Arrays.fill(indegree, 0);

        for (int[] edge : edges) {
            lists.get(edge[0]).add(edge[1]);
            indegree[edge[1]] = indegree[edge[1]] + 1;
        }

        ArrayList<Integer> ans = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for (int value : lists.get(node)) {
                indegree[value] = indegree[value] - 1;

                if (indegree[value] == 0) {
                    q.add(value);
                }
            }
        }

        return ans;
    }
}
