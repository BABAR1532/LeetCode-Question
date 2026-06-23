class Solution {

    class Pair {

        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;  for(int i = 0; i < size; i++){
   }
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int count = 0;

        Queue<Pair> q = new LinkedList<>();

        // 8 direction
        int[][] dir = {
            { 0, -1 },
            { -1, 0 },
            { 1, 0 },
            { 0, 1 },
            { -1, -1 },
            { 1, 1 },
            { 1, -1 },
            { -1, 1 },
        };

        if (grid[0][0] == 0) {
            q.add(new Pair(0, 0));
            grid[0][0] = 1;
        } else {
            return -1;
        }

        while (!q.isEmpty()) {
            int size = q.size();
            count++; // important

            for (int i = 0; i < size; i++) {
                Pair p = q.poll();

                int cRow = p.row;
                int cCol = p.col;

                if (cRow == row - 1 && cCol == col - 1) return count;

                for (int[] d : dir) {
                    int nRow = d[0] + cRow;
                    int nCol = d[1] + cCol;

                    if (
                        nRow < 0 ||
                        nCol < 0 ||
                        nRow >= row ||
                        nCol >= col ||
                        grid[nRow][nCol] == 1
                    ) {
                        continue;
                    }

                    grid[nRow][nCol] = 1;
                    q.add(new Pair(nRow, nCol));
                }
            }
        }

        return -1;
    }
}

///////
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//

class Solution {

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    class Pairs{
        int dis;
        Pair p;

        Pairs(int dis, Pair p){
            this.dis = dis;
            this.p = p;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] ans = new int[row][col];

        Arrays.fill(ans,Integer.MAX_VALUE);

        PriorityQueue<Pairs> q = new PriorityQueue<>();


        if(grid[0][0] == 0){

            Pair p = new Pair(0,0);
            q.offer(new Pairs(0,p));

            grid[0][0] = 1;

            // Mark the current distance
            ans[0][0]  = 0
        } else{
            return -1;
        }

        // 8 direction
        int[][] dir = {
            { 0, -1 },
            { -1, 0 },
            { 1, 0 },
            { 0, 1 },
            { -1, -1 },
            { 1, 1 },
            { 1, -1 },
            { -1, 1 },
        };


   while(!q.isEmpty()){

       Pairs node = q.poll();

       int dist = node.dis;
       Pair p = node.p;

       int cRow = p.row;
       int cCol = p.col;

       if(cRow == row - 1 && cCol == col -  1) return ans[cRow][cCol] + 1;

      for(int[] d: dir){

          int nRow = cRow + d[0];
          int nCol = cCol + d[1];

          if(nRow < 0 || nCol < 0 || nRow >= row || nCol >= col || grid[nRow][nCol] == 1) continue;

          int curDist = dist + 1;

          if(ans[nRow][nCol] > curDist){
              Pair node = new Pair(nRow,nCol);
              q.offer(Pairs(curDist,node));
              ans[nRow][nCol] = curDist;
              grid[nRow][nCol] = 1;
          }

      }

   }





   return -1;

    }
}
