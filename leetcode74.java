class Solution {

   // binary
   public static boolean binary(int[][] matrix, int start, int end,int row, int col, int target){

     // Base case
     if(start > end) return false;

     int mid = start + (end - start) / 2;

     int i = mid / col;
     int j = mid % col;


     if(target == matrix[i][j]){
        return true;
     }

     else if(target < matrix[i][j]){
          end = mid - 1;
     }

     else if(target > matrix[i][j]){
          start = mid + 1;
     }

    return binary(matrix, start, end, row, col, target);

   }


    public boolean searchMatrix(int[][] matrix, int target) {


        int row = matrix.length;
        int col = matrix[0].length;


        int start =  0
        int end = row * col  - 1;




        // Recursive
       return  binary(matrix,start, end, row, col, target);

    }
}
