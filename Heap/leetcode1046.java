class Solution {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < stones.length; i++) {
            pq.offer(stones[i]);
        }

        while (!pq.isEmpty()) {
            if (pq.size() <= 1) break;

            int value1 = pq.poll();
            int value2 = pq.poll();

            if (value1 == value2) continue;

            if (value1 < value2) {
                int ans = value2 - value1;
                pq.offer(ans);
            } else {
                int ans = value1 - value2;
                pq.offer(ans);
            }
        }

        return pq.size() == 0 ? 0 : pq.poll();
    }
}
