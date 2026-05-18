class Solution {

    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int size = adj.size();

        boolean[] visited = new boolean[size];

        Queue<Integer> q = new LinkedList<>();

        ArrayList<Integer> bfsArray = new ArrayList<>();

        q.add(0);

        while (!q.isEmpty()) {
            int node = q.poll();

            visited[node] = true;

            bfsArray.add(node);

            for (int i : adj.get(node)) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

        return bfsArray;
    }
}
