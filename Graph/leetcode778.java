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

    public int swimInWater(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int ans[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Pairs> q = new PriorityQueue<>((a, b) -> a.dist - b.dist);

        Pair p = new Pair(0, 0);

        q.offer(new Pairs(grid[0][0], p));

        ans[0][0] = grid[0][0];

        int dir[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!q.isEmpty()) {
            Pairs node = q.poll();

            Pair n = node.p;

            int cRow = n.row;
            int cCol = n.col;

            if (ans[cRow][cCol] < node.dist) continue;

            for (int[] d : dir) {
                int nRow = cRow + d[0];
                int nCol = cCol + d[1];

                if (nRow >= 0 && nCol >= 0 && nRow < row && nCol < col) {
                    int max = Math.max(node.dist, grid[nRow][nCol]);

                    if (max < ans[nRow][nCol]) {
                        ans[nRow][nCol] = max;

                        q.offer(new Pairs(max, new Pair(nRow, nCol)));
                    }
                }
            }
        }

        return ans[row - 1][col - 1];
    }
}
