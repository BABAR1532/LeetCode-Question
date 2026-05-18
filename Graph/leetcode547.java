class Solution {

    public void dfs(int[][] grid, int size, int node, boolean[] visited){
    
        visited[node] = true;
     
        for(int i = 0; i < size; i++){
          
          if(grid[node][i] == 1 && !visited[i]){
                   dfs(grid,size,i,visited);
             }
       }
    
    }
    

    public int findCircleNum(int[][] isConnected) {
        
        int size = isConnected.length;
        
        boolean visited[] = new boolean[size];
        
        Arrays.fill(visited,false);
        
        int count = 0;
        
        for(int i = 0; i < size; i++){

           if(!visited[i]){
               dfs(isConnected,size,i,visited);
               count++;
            }
    
       }
       
       return count;
          
    }
}



class Solution {

  
    public int findCircleNum(int[][] isConnected) {
        
        int size = isConnected.length;
        
  
        int count = 0;
        
      
          
    }
}



 










 








