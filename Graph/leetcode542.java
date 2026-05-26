class Pair {

    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {

    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;

        Queue<Pair> q = new LinkedList<>();

        int visited[][] = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int[][] dir = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

        int count = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            count++;

            for (int i = 0; i < size; i++) {
                Pair node = q.poll();

                int cRow = node.row;
                int cCol = node.col;

                for (int[] arr : dir) {
                    int nextRow = cRow + arr[0];
                    int nextCol = cCol + arr[1];

                    if (
                        nextCol >= col ||
                        nextRow >= row ||
                        nextCol < 0 ||
                        nextRow < 0
                    ) {
                        continue;
                    }

                    if (!visited[nextRow][nextCol]) {
                        visited[nextRow][nextCol] = true;
                        mat[nextRow][nextCol] = count++;
                        q.add(Pair(nextRow, nextCol));
                    }
                }
            }
        }

        return mat;
    }
}
