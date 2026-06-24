class Solution {

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Part of invalid cycle
            if (nums[i] == 0) continue;

            boolean checkDir = nums[i] > 0;

            int slow = i;
            int fast = i;

            while (true) {
                slow = getNext(nums, slow, checkDir);

                // Invalid cycle
                if (slow == -1) continue;

                // We are checking fast two time because there is exception error when you pass getnext(getnext());
                fast = getNext(nums, fast, checkDir);
                if (fast == -1) continue;

                fast = getNext(nums, fast, checkDir);
                if (fast == -1) continue;

                // Valid cycle
                if (slow == fast) return true;

                // Mark all the path as invalid path for further cycle check until direction is changed
                markDead(nums, i, checkDir);
            }
        }
    }

    // Method to return next index or if:
    // Direction changes
    // self loop

    public int getNext(int[] nums, int i, boolean checkDir) {
        // If direction changed

        if (nums[i] > 0 != checkDir) return -1;

        int n = nums.length;
        int next = (((i + nums[i]) % n) + n) % n;

        if (next == i) return -1;

        return next;
    }

    // Marks all the nodes which is part of failed path
    public void markDead(int[] nums, int current, boolean direction) {
        int n = nums.length;
        int start = current;

        while (nums[start] > 0 && nums[start] > 0 == direction) {
            int next = (((start + nums[start]) % n) + n) % n;
            nums[start] = 0;

            // Self loop condition
            if (start == current) break;

            start = next;
        }
    }
}
