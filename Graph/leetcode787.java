import java.util.Queue;

class State {

    int node;
    int dist;
    int stop;

    State(int node, int dist, int stop) {
        this.node = node;
        this.dist = dist;
        this.stop = stop;
    }
}

class Solution {

    public int findCheapestPrice(
        int n,
        int[][] flights,
        int src,
        int dst,
        int k
    ) {
        ArrayList<ArrayList<int[]>> lists = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
        }

        for (int[] list : flights) {
            lists.get(list[0]).add(new int[] { list[1], list[2] });
        }

        int ans[] = new int[n];

        Arrays.fill(ans, (int) 1e9);

        ans[src] = 0;

        Queue<State> q = new LinkedList<>();

        q.add(new State(src, 0, 0));

        while (!q.isEmpty()) {
            State st = q.poll();

            int node = st.node;
            int dist = st.dist;
            int stop = st.stop;

            if (stop > k) continue;

            for (int[] val : lists.get(node)) {
                int v = val[0];
                int w = val[1];

                int newCost = dist + w;

                if (ans[v] > newCost) {
                    ans[v] = newCost;
                    q.add(new State(v, newCost, stop + 1));
                }
            }
        }

        return ans[dst] == (int) 1e9 ? -1 : ans[dst];
    }
}

///////
// Bellman for way
//

class Solution {

    public int findCheapestPrice(
        int n,
        int[][] flights,
        int src,
        int dst,
        int k
    ) {
        int dist[] = new int[n];

        Arrays.fill(dist, (int) 1e8);

        dist[src] = 0;

        for (int i = 0; i <= k; i++) {
            int temp = Arrays.copyOf(dist, n);

            for (int[] value : flights) {
                int u = value[0];
                int v = value[1];
                int weight = value[2];

                if (dist[u] != (int) 1e8 && dist[u] + weight < dist[u]) {
                    temp[v] = dist[u] + weight;
                }
            }

            dist = temp;
        }

        return dist[dst] == (int) 1e8 ? -1 : dist[dst];
    }
}
