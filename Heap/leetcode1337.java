class Solution {

    class Pair {

        int index;
        int pos1;

        Pair(int index, int pos1) {
            this.index = index;
            this.pos1 = pos1;
        }
    }

    public static int binarySearch(int[] arr, int size) {
        int start = 0;
        int end = size - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid + 1] == 0) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return arr[end] == 0 ? -1 : end;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;

        int last1[] = new int[row];
        int index = 0;

        for (int[] arr : mat) {
            int minIndex = binarySearch(arr, col);
            last1[index] = minIndex;
            index++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.pos1 != a.pos2) return b.pos1 - a.pos2;
            return b.index - a.index;
        });

        for (int i = 0; i < row; i++) {
            pq.offer(new Pair(i, last1[i]));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int ans[] = new int[k];

        for (int i = 0; i < k; i++) {
            Pair val = pq.poll();
            ans[i] = val.index;
        }

        Collections.reverse(ans);

        return ans;
    }
}
