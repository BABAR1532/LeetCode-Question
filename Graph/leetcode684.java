class Solution {

    public int find(int value, int[] parent) {
        if (value == parent[value]) return value;
        return parent[value] = find(parent[value], parent);
    }

    public void union(int value1, int value2, int[] parent, int[] rank) {
        int parent1 = find(value1, parent);
        int parent2 = find(value2, parent);

        if (rank[parent1] > rank[parent2]) {
            parent[parent2] = parent1;
        } else if (rank[parent1] < rank[parent2]) {
            parent[parent1] = parent2;
        } else if (rank[parent1] == rank[parent2]) {
            parent[parent1] = parent2;
            rank[parent2]++;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        int[] parent = new int[n + 1];
        int rank[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        Arrays.fill(rank, 0);

        int ans[] = new int[2];

        for (int[] edge : edges) {
            int value1 = edge[0];
            int value2 = edge[1];

            int parent1 = find(value1, parent);
            int parent2 = find(value2, parent);

            if (parent1 == parent2) {
                ans[0] = value1;
                ans[1] = value2;
            }

            union(value1, value2, parent, rank);
        }

        return ans;
    }
}
