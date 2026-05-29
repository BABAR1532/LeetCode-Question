import java.util.Arrays;

class Pair {

    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Pairs {

    int dist;
    Pair p;

    Pairs(int dist, Pair p) {
        this.dist = dist;
        this.p = p;
    }
}

class Solution {

    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;

        int ans[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Pairs> q = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        Pair p = new Pair(0, 0);
        q.offer(new Pairs(0, p));

        ans[0][0] = 0;

        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!q.isEmpty()) {
            Pairs node = q.poll();

            Pair pi = node.p;

            int cRow = pi.row;
            int cCol = pi.col;

            if (ans[cRow][cCol] < node.dist) continue;

            for (int[] d : dir) {
                int nRow = cRow + d[0];
                int nCol = cCol + d[1];

                if (nRow >= 0 && nCol >= 0 && nRow < row && nCol < col) {
                    int diff = Math.abs(
                        heights[cRow][cCol] - heights[nRow][nCol]
                    );

                    if (node.dist > diff) {
                        diff = node.dist;
                    }

                    if (ans[nRow][nCol] > diff) {
                        ans[nRow][nCol] = diff;

                        Pair v = new Pair(nRow, nCol);
                        q.offer(new Pairs(diff, v));
                    }
                }
            }
        }

        return ans[row - 1][col - 1];
    }
}
