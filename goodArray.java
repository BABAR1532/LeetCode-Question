import java.util.*;

public class goodArray {

    // gcd function
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public static void main(String[] args) {
        int arr[] = { 12, 5, 7, 23 };

        int gcdValue = arr[0];

        for (int i = 1; i < arr.length; i++) {
            gcdValue = gcd(gcdValue, arr[i]);

            if (gcdValue == 1) {
                System.out.println("Good array");
                break;
            }
        }

        if (gcdValue == 1) {
            System.out.println("Good array");
        }
    }
}
