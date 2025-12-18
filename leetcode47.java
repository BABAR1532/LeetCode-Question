class Solution {

    public static List<List<Integer>> backTrack(int[] nums,
                                                List<Integer> path,
                                                boolean[] used) {

        // Base case
        if (path.size() == nums.length) {
            List<List<Integer>> l = new ArrayList<>();
            l.add(new ArrayList<>(path)); // COPY
            return l;
        }

        List<List<Integer>> ans = new ArrayList<>();

        // Recursion + Backtracking
        for (int i = 0; i < nums.length; i++) {

            // already used
            if (used[i]) continue;

            // duplicate skip condition
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            // choose
            used[i] = true;
            path.add(nums[i]);

            // explore
            ans.addAll(backTrack(nums, path, used));

            // un-choose (BACKTRACK)
            path.remove(path.size() - 1);
            used[i] = false;
        }

        return ans;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums); // IMPORTANT

        boolean[] visited = new boolean[nums.length];

        return backTrack(nums, new ArrayList<>(), visited);
    }
}
