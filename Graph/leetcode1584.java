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
