class Solution {

    public int find(int i, int[] parent) {
        if (i == parent[i]) return i;

        return parent[i] = find(parent[i], parent);
    }

    public void union(int value1, int value2, int[] parent) {
        int parent1 = find(value1, parent);
        int parent2 = find(value2, parent);

        parent[parent1] = parent2;
    }

    public boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] parent = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                if (u < v) {
                    int parentU = find(u, parent);
                    int parentV = find(v, parent);

                    if (parentU == parentV) return true;

                    union(u, v, parent);
                }
            }
        }

        return false;
    }
}
