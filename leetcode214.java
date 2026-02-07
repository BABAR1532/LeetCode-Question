class Solution {

    public String shortestPalindrome(String s) {
        // Step 1: reverse string
        String rev = new StringBuilder(s).reverse().toString();

        // Step 2: build combined string
        String combined = s + "#" + rev;

        char[] arr = combined.toCharArray();
        int len = arr.length;

        int[] lps = new int[len];

        int prefix = 0;
        int suffix = 1;

        // Step 3: build LPS (your style)
        while (suffix < len) {
            if (arr[suffix] == arr[prefix]) {
                lps[suffix] = prefix + 1;
                prefix++;
                suffix++;
            } else {
                if (prefix == 0) {
                    lps[suffix] = 0;
                    suffix++;
                } else {
                    prefix = lps[prefix - 1];
                }
            }
        }

        // Step 4: length of longest palindromic prefix
        int palLen = lps[len - 1];

        // Step 5: remaining part
        String add = s.substring(palLen);

        // Step 6: reverse remaining and add in front
        return new StringBuilder(add).reverse().toString() + s;
    }
}
