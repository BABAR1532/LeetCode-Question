import java.util.PriorityQueue;
//////
////////
//
//
// same appoach but diffrent style

import java.util.PriorityQueue;

class Solution {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];

            if (diff < 0) continue;

            if (diff <= bricks) {
                bricks -= diff;
                pq.offer(diff);
            } else if (ladders > 0) {
                if (!pq.isEmpty() && pq.peek() > diff) {
                    bricks += pq.poll();

                    bricks -= diff;

                    pq.offer(diff);
                }

                ladders--;
            } else {
                return i;
            }
        }

        return heights.length - 1;
    }
}

class Solution {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];

            if (diff > 0) {
                pq.offer(diff);
                bricks -= diff;

                if (bricks < 0) {
                    if (ladders > 0) {
                        bricks += pq.poll(); // use ladder for biggest climb
                        ladders--;
                    } else {
                        return i;
                    }
                }
            }
        }

        return heights.length - 1;
    }
}
