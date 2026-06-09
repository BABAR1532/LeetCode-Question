import java.util.PriorityQueue;

class Solution {

    class Pair {

        int dist;
        int index;

        Pair(int dist, int index) {
            this.dist = dist;
            this.index = index;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        PriorityQueue<Pair> q = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        int cost = 0;

        boolean[] mst = new boolean[n];

        // Index as node and distance will be 0
        q.offer(new Pair(0, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            int index = p.index;
            int c = p.dist;

            if (mst[index]) continue;

            mst[index] = true;
            cost += c;

            for (int i = 0; i < n; i++) {
                if (!mst[i]) {
                    int manhattenDis =
                        Math.abs(points[index][0] - points[i][0]) +
                        Math.abs(points[index][1] - points[i][1]);
                    q.add(Pair(i, manhattenDis));
                }
            }
        }

        return cost;
    }
}

/////
//
//
//

// kruskal with dsu (it is not an optimize soln)

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
        } else {
            parent[parent1] = parent2;
            rank[parent2]++;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();

        int size = points.length;

        // Generating the edges

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int dist =
                    Math.abs(points[i][0] - points[j][0]) +
                    Math.abs(points[i][1] - points[j][1]);

                edges.add(new int[] { i, j, dist });
            }
        }

        Collections.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        int parent[] = new int[size];
        int rank[] = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }

        Arrays.fill(rank, 0);

        int cost = 0;

        for (int[] l : edges) {
            int value1 = l[0];
            int value2 = l[1];
            int dist = l[2];

            int parent1 = find(value1, parent);
            int parent2 = find(value2, parent);

            if (parent1 == parent2) continue;

            union(value1, value2, parent, rank);
            cost += dist;
        }

        return cost;
    }
}
