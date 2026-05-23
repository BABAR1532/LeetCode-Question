class Solution {

    class Pair {

        int row;
        int col;
        int pRow;
        int pCol;

        Pair(int row, int col, int pRow, int pCol) {
            this.row = row;
            this.col = col;
            this.pRow = pRow;
            this.pCol = pCol;
        }
    }

    public boolean bfs(
        char[][] grid,
        int row,
        int col,
        int rSize,
        int cSize,
        boolean[][] visited
    ) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col, -1, -1));

        visited[row][col] = true;

        int dir[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        while (!q.isEmpty()) {
            Pair node = q.poll();

            int cRow = node.row;
            int cCol = node.col;

            int pRow = node.pRow;
            int pCol = node.pCol;

            for (int[] d : dir) {
                int nRow = cRow + d[0];
                int nCol = cCol + d[1];

                if (
                    nRow < 0 ||
                    nCol < 0 ||
                    nRow >= rSize ||
                    nCol >= cSize ||
                    grid[cRow][cCol] != grid[nRow][nCol]
                ) {
                    continue;
                } else if (!visited[nRow][nCol]) {
                    visited[nRow][nCol] = true;
                    q.add(new Pair(nRow, nCol, cRow, cCol));
                } else if (pRow != nRow || pCol != nCol) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean containsCycle(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j]) {
                    if (bfs(grid, i, j, row, col, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
