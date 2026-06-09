import java.util.PriorityQueue;

class Solution {

    public ArrayList<Integer> mergeArrays(int[][] mat) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> a.value - b.value
        );

        int row = mat.length;
        int col = mat[0].length;

        for (int i = 0; i < row; i++) {
            pq.offer(new Pair(i, 0, mat[i][0]));
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            int r = p.row;
            int c = p.col;
            ans.add(p.value);

            if (c < col - 1) {
                pq.offer(new Pair(r, c + 1, mat[r][c + 1]));
            }
        }

        return ans;
    }
}
