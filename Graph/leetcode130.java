class Solution {

    class Pair {

        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void solve(char[][] board) {
        int rowSize = board.length;
        int colSize = board[0].length;

        Queue<Pair> q = new LinkedList<>();

        boolean[][] visited = new boolean[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (
                    (i == 0 ||
                        j == 0 ||
                        i == rowSize - 1 ||
                        j == colSize - 1) &&
                    board[i][j] == 'O'
                ) {
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int size = q.size();

            Pair p = q.poll();
            // Mark visit

            int cRow = p.row;
            int cCol = p.col;

            for (int[] d : dir) {
                int nRow = d[0] + cRow;
                int nCol = d[1] + cCol;

                if (
                    nRow >= 0 &&
                    nCol >= 0 &&
                    nRow < rowSize &&
                    nCol < colSize &&
                    board[nRow][nCol] == 'O' &&
                    !visited[nRow][nCol]
                ) {
                    q.add(new Pair(nRow, nCol));
                    visited[nRow][nCol] = true;
                }
            }
        }

        // Start marking
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
