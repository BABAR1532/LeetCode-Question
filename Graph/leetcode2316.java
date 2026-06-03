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

    public long countPairs(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];

        Arrays.fill(rank, 0);

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int edge[] : edges) {
            int value1 = edge[0];
            int value2 = edge[1];

            int parent1 = find(value1, parent);
            int parent2 = find(value2, parent);

            if (parent1 == parent2) continue;

            union(value1, value2, parent, rank);
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int cParent = find(parent[i], parent);

            if (map.contains(cParent)) {
                map.put(cParent, map.getOrDefault(cParent, 0) + 1);
            } else {
                map.put(cParent, 1);
            }
        }

        int[] regionCount = new int[map.size()];

        if (map.size() == 1) return 0;

        int i = 0;

        for (Integer value : map.values()) {
            regionCount[i] = value;
            i++;
        }

        long FinalAns = 0;

        for (int count = 0; count < regionCount.length - 1; count++) {
            for (int j = count + 1; j < regionCount.length; j++) {
                FinalAns += regionCount[count] * regionCount[j];
            }
        }

        return FinalAns;
    }
}
