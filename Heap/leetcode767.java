class Solution {

    class Pair {

        char c;
        int count;

        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    class Data {

        char a;
        int count;
        int nextTime;

        Data(char a, int count, int nextTime) {
            this.a = a;
            this.count = count;
            this.nextTime = nextTime;
        }
    }

    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.count - a.count
        );

        for (HashMap.Entry<Character, Integer> set : map.entrySet()) {
            pq.offer(new Pair(set.getKey(), set.getValue()));
        }

        Queue<Data> q = new LinkedList<>();

        int time = 0;

        while (!q.isEmpty() && !pq.isEmpty()) {
            time++;

            if (!q.isEmpty() && q.peek().nextTime <= time) {
                Data d = q.poll();

                pq.offer(new Pair(d.a, d.count));
            }

            if (pq.isEmpty()) {
                Pair p = pq.poll();

                int Newcount = p.count - 1;
                char c = p.c;

                ans += c;

                if (newcount > 0) {
                    q.offer(new Data(c, newCount, time + 2));
                }
            }
        }

        return ans;
    }
}
