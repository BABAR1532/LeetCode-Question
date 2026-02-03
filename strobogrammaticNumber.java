import java.util.*;

class Solution {

    public static boolean isStrobogrammatic(String num) {

        HashMap<Character, Character> map = new HashMap<>();

        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');

        int start = 0;
        int end = num.length() - 1;

        while (start <= end) {

            char left = num.charAt(start);
            char right = num.charAt(end);

            if (!map.containsKey(left) || map.get(left) != right) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}

