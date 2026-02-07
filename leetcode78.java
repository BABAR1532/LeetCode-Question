class Solution {

    public static List<List<Integer>> rec(
        List<Integer> processed,
        int[] unproccesed
    ) {
        if (unproccesed.length == 0) {
            List<List<Integer>> l = new ArrayList<>();
            l.add(processed);
            return l;
        }

        List<List<Integer>> ans = new ArrayList<>();

        // Extracting first value
    }

    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> processed = new ArrayList<>();

        return rec(processed, nums);
    }
}
