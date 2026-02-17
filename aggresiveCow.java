class Solution {

    // Checking cows arrangement
    public static boolean checkCows(int[] arr, int k, int key) {
        int n = arr.length;

        int current = 0;
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[current] >= key) {
                count++;
                current = i;

                if (count == k) return true;
            }
        }

        return false;
    }

    public int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;

        // Sorting array
        Arrays.sort(stalls);

        int start = 1;
        int end = stalls[n - 1] - stalls[0];
        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (checkCows(stalls, k, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
