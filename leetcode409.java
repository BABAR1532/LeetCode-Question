class Solution {

    public int longestPalindrome(String s) {
        Map<String, Integer> map = new HashMap<>();

        for (char a : s.toCharArray()) {
            map.put(a, map.getOrDefualt(a, 0) + 1);
        }

        int length = 0;
        boolean flag = false;

        for (int count : map.values()) {
            if (count % 2 == 0) {
                length += count;
            } else {
                length += (count - 1);
                flag = true;
            }
        }

        return flag ? length + 1 : length;
    }
}
