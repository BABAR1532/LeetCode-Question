class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 0;

        // Finding maximum element
        for (int pile : piles) {
            end = Math.max(end, pile);
        }

        int ans = end;

        while (start <= end) {
            // Finding mid

            int mid = start + (end - start) / 2;

            // Calcuating the total hours using everyMid value
            long totalHours = 0;

            for (int pile : piles) {
                totalHours += (pile + mid - 1) / mid;
            }

            if (totalHours <= h) {
                ans = mid;
                // Trying smaller value
                end = mid - 1;
            } else {
                // Need bigger speed
                start = mid + 1;
            }
        }

        return ans;
    }
}
