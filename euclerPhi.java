import java.util.*;

public class EulerPhi {

    public static int euler(int n) {

        int ans = n;   // φ(n) starts as n

        // Check all prime factors up to √n
        for (int i = 2; i * i <= n; i++) {

            if (n % i == 0) {

                // Remove all multiples of i
                while (n % i == 0) {
                    n /= i;
                }

                // Apply formula
                ans -= ans / i;
            }
        }

        // If n is still > 1, it is a prime factor
        if (n > 1) {
            ans -= ans / n;
        }

        return ans;
    }

    public static void main(String[] args) {

        int a = 12;
        int phi = euler(a);

        System.out.println(phi);  // Output: 4
    }
}
