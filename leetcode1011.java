class Solution {

    public static int calculateDay(int[] arr, int key) {
        int maxWeight = 0;
        int days = 1;

        for (int value : arr) {
            if (maxWeight + value > key) {
                days++;
                maxWeight = value;
            } else {
                maxWeight += value;
            }
        }

        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int end = 0; // total
        int start = 0; // maxium weight

        for (int weight : weights) {
            end += weight;
            start = Math.max(start, weight);
        }

        int ans = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (calculateDay(weights, mid) <= days) {
                end = mid - 1;
                ans = mid;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}
