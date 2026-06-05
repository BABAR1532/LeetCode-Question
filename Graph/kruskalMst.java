import java.util.PriorityQueue;

class Solution {

    public int find(int value, int[] parent) {
        if (value == parent[value]) return value;

        return parent[value] = find(parent[value], parent);
    }

    public void union(int value1, int value2, int[] parent, int[] rank) {
        int parent1 = find(value1, parent);
        int parent2 = find(value2, parent);

        if (rank[parent1] < rank[parent2]) {
            parent[parent1] = parent2;
        } else if (rank[parent1] > rank[parent2]) {
            parent[parent2] = parent1;
        } else if (rank[parent1] == rank[parent2]) {
            parent[parent1] = parent2;
            rank[parent2]++;
        }
    }

    public int spanningTree(int V, int[][] edges) {
        int[] parent = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        int rank[] = new int[V];

        int cost = 0;

        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        for (int[] a : edges) {
            int value1 = a[0];
            int value2 = a[1];
            int dist = a[2];

            int parent1 = find(value1, parent);
            int parent2 = find(value2, parent);

            if (parent1 == parent2) continue;

            cost += dist;
            union(value1, value2, parent, rank);
        }

        return cost;
    }
}
