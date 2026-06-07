import java.util.PriorityQueue;

class Pair {

    int index;
    int distance;

    Pair(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
}

class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.distance != b.distance) return b.distance - a.distance;

            return b.index - a.index;
        });

        for (int i = 0; i < arr.length; i++) {
            int cost = Math.abs(arr[i] - x);

            pq.offer(new Pair(i, cost));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            Pair p = pq.poll();

            list.add(arr[p.index]);
        }

        Collections.sort(list);

        return list;
    }
}

// Another Approach
class Solution {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int size = arr.length;

        int start = 0;
        int end = size - k;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (x - arr[mid] > arr[mid + k] - x) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < left + k; i++) {
            list.add(arr[i]);
        }

        return ans;
    }
}
