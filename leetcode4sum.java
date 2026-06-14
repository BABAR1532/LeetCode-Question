class Solution {

    public void twoSum(
        int[] nums,
        int start,
        int end,
        int a,
        int b,
        long target,
        List<List<Integer>> lists
    ) {
        while (start < end) {
            long sum = (long) nums[start] + nums[end];

            if (sum == target) {
                lists.add(
                    new ArrayList<>(Arrays.asList(a, b, nums[start], nums[end]))
                );

                while (start < end && nums[start] == nums[start + 1]) start++;
                while (start < end && nums[end] == nums[end - 1]) end--;

                // Right postion
                start++;
                end--;
            } else if (sum > target) {
                end--;
            } else {
                start++;
            }
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < nums.length - 3; i++) {
            // Removing duplicates calculation
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Solving two sum
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                long CurrentTarget = (long) target - nums[i] - nums[j];

                twoSum(
                    nums,
                    j + 1,
                    nums.length - 1,
                    nums[i],
                    nums[j],
                    CurrentTarget,
                    lists
                );
            }
        }

        return lists;
    }
}
