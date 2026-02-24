class Solution {

    public int countPrimeSetBits(int left, int right) {
        // HashSet
        HashSet<Integer> primes = new HashSet<>(
            Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19)
        );

        int result = 0;

        for (int i = left; i <= right; i++) {
            int setBits = Integer.bitCount(i);

            if (primes.contains(setBits)) {
                result++;
            }
        }

        return result;
    }
}
