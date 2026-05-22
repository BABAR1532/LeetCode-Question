class Solution {

    public static int validIndex(String s, int index) {
        int skip = 0;

        while (index >= 0) {
            if (s.charAt(index) == '#') {
                skip++;
                index--;
            } else if (skip > 0) {
                skip--;
                index--;
            } else {
                break;
            }
        }

        return index;
    }

    public boolean backspaceCompare(String s, String t) {
        int s1 = s.length() - 1;
        int s2 = t.length() - 1;

        while (s1 >= 0 || s2 >= 0) {
            int s1Index = validIndex(s, s1);
            int s2Index = validIndex(t, s2);

            if (s1Index < 0 && s2Index < 0) return true;
            if (s1Index < 0 || s2Index < 0) return false;
            if (s.charAt(s1Index) != t.charAt(s2Index)) return false;

            s1 = s1Index - 1;
            s2 = s2Index - 1;
        }

        return true;
    }
}

//// WE can also solve this problem using stack easily
