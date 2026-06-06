class Solution {

    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a, b) -> {
                if (!a.getValue().equals(b.getValue())) {
                    // normal condition
                    return a.getValue() - b.getValue(); // smaller freq first
                }

                return b.getKey().compareTo(a.getKey()); // lexicogrpahical sorting
            }
        );

        for (Map.Entry<String, Integer> m : map.entrySet()) {
            pq.offer(m);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            Map.Entry<String, Integer> pair = pq.poll();

            ans.add(pair.getKey());
        }

        Collections.reverse(ans);

        return ans;
    }
}
