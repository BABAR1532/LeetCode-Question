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


// Another Solution

class Solution {

    public static boolean search(int[][] matrix, int key, int row, int size) {
        int start = 0;
        int end = size - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (matrix[row][mid] == key) return true;
            else if (matrix[row][mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static int findRow(int[][] matrix, int target, int totalRow) {
        int start = 0;
        int end = totalRow - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (matrix[mid][0] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return end;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int totalRow = matrix.length;

        // Searching target value row
        int targetRow = findRow(matrix, target, totalRow);

        if (targetRow < 0) return false;

        // Normal Binary search
        return search(matrix, target, targetRow, matrix[0].length);
    }
}
