class Solution {

    public static int countMin(int m, int n, int key) {
        int row = m;
        int col = 1;
        int count = 0;

        while (row >= 1 && col <= n) {
            if (row * col <= key) {
                count += row; // all elements above in this column are valid
                col++; // move right
            } else {
                row--; // move up
            }
        }

        return count;
    }

    public int findKthNumber(int m, int n, int k) {
        int start = 1;
        int end = m * n;

        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (countMin(m, n, mid) >= k) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}
