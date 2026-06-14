import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < tasks.length; i++) {
            char c = tasks[i];

            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        pq.addAll(map.values());

        // Queue (For cooldown)(next processing time)
        Queue<int[]> q = new LinkedList<>();

        int time = 0;

        while (!q.isEmpty() || !pq.isEmpty()) {
            time++;

            if (!q.isEmpty() && q.peek()[1] == time) {
                pq.offer(q.poll()[0]);
            }

            if (!pq.isEmpty()) {
                int count = pq.poll() - 1;

                if (count > 0) {
                    q.offer(new int[] { count, time + n + 1 });
                }
            }
        }

        return time;
    }
}
