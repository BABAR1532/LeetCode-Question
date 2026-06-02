class Solution {

    public void floydWarshall(int[][] dist) {
        int row = dist.length;
        int col = dist[0].length;

        for (int via = 0; via < row; via++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (
                        dist[i][via] == (int) 1e8 || dist[via][j] == (int) 1e8
                    ) continue;

                    if (dist[i][via] + dist[via][j] < dist[i][j]) {
                        dist[i][j] = dist[i][via] + dist[via][j];
                    }
                }
            }
        }

        // if Negative cycle will asked
        // for(int i = 0; i < row; i++){
        //     if(dist[i][i] < 0) // cycle
        // }
        //
        //
    }
}
