import java.util.*;

class notSpecial {

    // method for simple sieve
    public static boolean[] sieve(int number) {
        boolean[] isPrime = new boolean[number + 1];

        Arrays.fill(isPrime, true);

        if (number >= 1) isPrime[1] = false;
        if (number >= 0) isPrime[0] = false;

        for (int i = 2; i * i <= number; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= number; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }

    // method to countNotSpecial
    public static int countNotSpecial(int l, int r) {
        int total = (r - l) + 1;

        int limit = (int) Math.sqrt(r);

        boolean[] isPrime = sieve(limit);

        int countSpecial = 0;

        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                long primeSquare = (long) i * i;

                if (primeSquare >= l && primeSquare <= r) {
                    countSpecial++;
                }
            }
        }

        return total - countSpecial;
    }

    public static void main(String[] args) {
        int l = 1,
            r = 25;

        System.out.println(countNotSpecial(l, r));
    }
}
