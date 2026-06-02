import java.util.HashSet;

class Solution {

    public int find(int value, int[] ans) {
        if (value == ans[value]) return value;

        return ans[value] = find(ans[value], ans);
    }

    public void union(int value1, int value2, int[] ans, int[] rank) {
        int parent1 = find(value1, ans);
        int parent2 = find(value2, ans);

        if (rank[parent1] > rank[parent2]) {
            ans[parent2] = parent1;
        } else if (rank[parent1] < rank[parent2]) {
            ans[parent1] = parent2;
        } else if (rank[parent1] == rank[parent2]) {
            ans[parent1] = parent2;
            rank[parent2]++;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        int[] ans = new int[n];
        int[] rank = new int[n];

        Arrays.fill(rank, 0);

        for (int i = 0; i < n; i++) {
            ans[i] = i;
        }

        int extraCable = 0;

        for (int[] v : connections) {
            int value1 = v[0];
            int value2 = v[1];

            int parent1 = find(value1, ans);
            int parent2 = find(value2, ans);

            if (parent1 == parent2) {
                extraCable++;
                continue;
            }

            union(value1, value2, ans, rank);
        }

        HashSet<Integer> map = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (map.contains(ans[i])) continue;

            map.add(ans[i]);
        }

        int region = map.size();

        if (region - 1 <= extraCable) {
            return region - 1;
        } else {
            return -1;
        }
    }
}
