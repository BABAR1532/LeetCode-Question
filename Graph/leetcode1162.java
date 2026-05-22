class Solution {

    class Pair {

        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int maxDistance(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int waterCount = 0;

        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Pair(i, j));
                } else {
                    waterCount++;
                }
            }
        }

        if (waterCount == 0) return -1;

        int dir[][] = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
        int dis = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            dis++;

            for (int i = 0; i < size; i++) {
                Pair node = q.poll();

                for (int[] d : dir) {
                    int cr = node.row + d[0];
                    int cc = node.col + d[1];

                    if (
                        cr < row &&
                        cc < col &&
                        cr >= 0 &&
                        cc >= 0 &&
                        grid[cr][cc] == 0
                    ) {
                        grid[cr][cc] = 1;
                        q.add(new Pair(cr, cc));
                    }
                }
            }
        }

        return dis;
    }
}
s
