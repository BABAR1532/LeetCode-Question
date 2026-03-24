import java.util.*;

public class binaryPalindrome {

    // Check checkPalindrome
    public static boolean checkPalindrome(String value) {
        int start = 0;
        int end = value.length() - 1;

        while (start <= end) {
            if (value.charAt(start) != value.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        int number = 20;

        String sNumber = Integer.toBinaryString(number);

        boolean isPalindrome = checkPalindrome(sNumber);

        System.out.println(isPalindrome);
    }
}
