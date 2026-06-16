class Solution {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int time = 0;

        for (int[] a : courses) {
            int duration = a[0];
            int maxTime = a[1];

            pq.offer(duration);
            time += duration;

            if (time > maxTime) {
                time -= pq.poll();
            }
        }

        return pq.size();
    }
}
