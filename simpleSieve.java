import java.util.*;

public class simpleSieve {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = scan.nextInt();

        boolean[] isPrime = new boolean[number + 1];

        Arrays.fill(isPrime, true);

        // Simple Seive code
        for (int i = 2; i * i <= number; i++) {
            if (isPrime[i]) {
                // Sieve multiple of i
                for (int j = i * i; j <= number; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Variable for counting prime number
        int count = 0;

        for (int i = 2; i <= number; i++) {
            if (isPrime[i]) count++;
        }

        System.out.println(count);
    }
}
