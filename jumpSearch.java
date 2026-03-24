import java.util.*;

class jumpSearch {

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 6, 7, 91, 200 };

        int n = arr.length;
        int prev = 0;
        int step = (int) Math.ceil(Math.sqrt(n));

        int target = 200;

        // Math.min solve array Index out of bond problem (nothing more than that)
        while (arr[Math.min(step, n) - 1] < target) {
            prev = step;

            step += (int) Math.ceil(Math.sqrt(n));

            if (prev >= n) return -1; // No included
        }

        // Linear Search
        for (int i = prev; i < Math.min(step, n); i++) {
            if (arr[i] == target) {
                return 1; // Element finded
            }
        }

        return 0;
    }
}
