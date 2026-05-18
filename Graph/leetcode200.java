class Solution {

    // dfs
    public static void dfs(char[][] grid, int row, int col, int m, int n) {
        if (
            row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == '0'
        ) {
            return;
        }

        if (grid[row][col] == '-1') return;

        grid[row][col] = '-1';

        //dfs calls
        dfs(grid, row, col + 1, m, n);
        dfs(grid, row + 1, col, m, n);
        dfs(grid, row - 1, col, m, n);
        dfs(grid, row, col - 1, m, n);
    }

    public int numIslands(char[][] grid) {
        int count = 0;

        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, m, n);
                    count++;
                }
            }
        }

        return count;
    }
}

////////////////////////////////////////
// ///////////////////////////////////////
/



class Pair{
    int row;
    int col;

    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public static void bfs(char[][] grid, int row,int col, int m, int n){

   Queue<Pair> q = new LinkedList<>();

   q.add(new Pair(row,col));
   grid[row][col] = '0';

   int[] dr = {0,1,0,-1};
   int[] dc = {1,0,-1,0};

   while(!q.isEmpty()){

       Pair node = q.poll;

       int currentRow = pair.row ;
       int currentCol = pair.col;

       for(int i = 0; i < 4; i++){

            int nextRow = currentRow + dr[i];
            int nextCol = currentCol + dc[i];


             if(nextRow <= m && nextCol >= n && nextRow >= 0 && nextCol >= 0 && grid[nextRow][nextCol] == '1'){
                 q.add(new Pair(nextRow,nextCol));
                 grid[currentRow][currentCol] = '0';
             }
       }
   }

}



// Bfs
public int numIslands(char[][] grid) {
    int count = 0;

    int n = grid.length;
    int m = grid[0].length;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == '1') {
                bfs(grid, i, j, m, n);
                count++;
            }
        }
    }

    return count;
}
}
