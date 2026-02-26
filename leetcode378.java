class Solution {

    public static int countNum(int[][] matrix, int key) {
        int col = matrix[0].length - 1;
        int row = matrix.length - 1;

        int count = 0;

        int colLimit = 0;
        int rowLimit = row;

        while (rowLimit >= 0 && colLimit <= col) {
            // Row wise elimination
            if (matrix[rowLimit][colLimit] <= key) {
                count += rowLimit + 1;
                colLimit++;
            } else {
                rowLimit--;
            }
        }

        return count;
    }

    public int kthSmallest(int[][] matrix, int k) {
        int col = matrix[0].length - 1;
        int row = matrix.length - 1;

        int ans = 0;

        int start = matrix[0][0];
        int end = matrix[row][col];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (countNum(matrix, mid) >= k) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}
