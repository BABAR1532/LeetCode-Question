class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int start = 1;
        int end = numbers.length;

        while (start < end) {
            if (numbers[start - 1] + numbers[end - 1] == target) {
                break;
            } else if (numbers[start - 1] + numbers[end - 1] > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[] { start, end };
    }
}
