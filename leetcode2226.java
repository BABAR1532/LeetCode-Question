class Solution {

    // Method for candyMax
    public static boolean candyMax(int[] candies, int k, int key) {
        // If you repeativebly divide and add to count it may be overflow
        long count = 0;

        for (int candy : candies) {
            count += candy / key;
        }

        return count >= k;
    }

    public int maximumCandies(int[] candies, long k) {
        int n = candies.length - 1;
        int start = 1;
        int end = 0;

        for (int candy : candies) {
            end = Math.max(end, candy);
        }

        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (candyMax(candies, k, mid)) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }
}
