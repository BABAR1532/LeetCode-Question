class Solution {

    public int next(int value) {
        int ans = 0;

        while (value != 0) {
            int digit = value % 10;
            ans += (digit * digit);
            value /= 10;
        }

        return ans;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> map = new HashSet<>();

        if (n == 1) return true;

        map.add(n);

        while (true) {
            int newNum = next(n);

            if (newNum == 1) return true;

            if (map.contains(newNum)) return false;

            map.add(newNum);
            n = newNum;
        }
    }
}

// floyd cycle detection
class Solution {

    public int next(int value) {
        int ans = 0;

        while (value != 0) {
            int digit = value % 10;
            ans += (digit * digit);
            value /= 10;
        }

        return ans;
    }

    public boolean isHappy(int n) {
        int left = next(n);
        int right = next(next(n));

        while (right != 1 && left != right) {
            left = next(left);
            right = next(next(right));
        }

        return right == 1;
    }
}
