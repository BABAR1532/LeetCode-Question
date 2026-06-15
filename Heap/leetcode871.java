class Solution {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int fuel = startFuel;
        int i = 0;
        int stop = 0;
        int n = stations.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        while (fuel < target) {
            while (i < n && stations[i][0] <= fuel) {
                pq.offer(stations[i][1]);
                i++;
            }

            if (!pq.isEmpty()) {
                return -1;
            }

            fuel += pq.poll();
            stop++;
        }

        return stop;
    }
}
