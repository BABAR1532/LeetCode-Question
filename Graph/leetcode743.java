class Solution {

    class Pair {

        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> lists = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            lists.add(new ArrayList<>());
        }

        // Creating ArrayList
        for (int[] time : times) {
            lists.get(time[0]).add(new Pair(time[1], time[2]));
        }

        int ans[] = new int[n + 1];

        Arrays.fill(ans, Integer.MAX_VALUE);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        minHeap.offer(new int[] { 0, k });
        ans[k] = 0;

        while (!minHeap.isEmpty()) {
            int[] value = minHeap.poll();

            int dist = value[0];
            int node = value[1];

            if (dist > ans[node]) continue;

            for (Pair p : lists.get(node)) {
                int weight = p.dist + dist;

                if (weight < ans[p.node]) {
                    ans[p.node] = weight;
                    minHeap.offer(new int[] { weight, p.node });
                }
            }
        }

        int minAns = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if (i != k && ans[i] > minAns) {
                minAns = ans[i];
            }
        }

        return minAns == Integer.MAX_VALUE ? -1 : minAns;
    }
}
