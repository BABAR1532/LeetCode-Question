import java.util.PriorityQueue;

class Solution {

    class pair {

        int row;
        int col;
        double dist;

        pair(int row, int col, double dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) ->
            Double.compare(b.dist, a.dist)
        );

        for (int[] point : points) {
            double distance = Math.sqrt(
                (point[0] * point[0]) + (point[1] * point[1])
            );

            pq.offer(new pair(point[0], point[1], distance));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int ans[][] = new int[k][2];

        for (int i = 0; i < k; i++) {
            pair p = pq.poll();
            ans[i][0] = p.row;
            ans[i][1] = p.col;
        }

        return ans;
    }
}
