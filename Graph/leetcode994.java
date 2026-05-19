class Solution {

    class Pair {

        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        int fresh = 0;

        int time = 0;

        // Counting rotten oranges and add to Qeueu and

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                } else if (grid[i][j] == 2) {
                    // Adding to Queue
                    q.add(new Pair(i, j));
                }
            }
        }

        int dir[][] = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            time++;

            for (int i = 0; i < size; i++) {
                Pair node = q.poll();

                int rowD = node.row;
                int colD = node.col;

                for (int[] d : dir) {
                    int nextRow = rowD + d[0];
                    int nextCol = colD + d[1];

                    if (
                        nextRow >= row ||
                        nextCol >= col ||
                        nextRow < 0 ||
                        nextCol < 0
                    ) continue;

                    if (grid[nextRow][nextCol] != 1) continue;

                    grid[nextRowl][nextCol] = 2;
                    fresh--;

                    q.add(new Pair(nextRow, nextCol));
                }
            }
        }

        return fresh == 0 ? time : -1;
    }
}
