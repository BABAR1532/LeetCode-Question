class Solution {

    public boolean isPowerOfFour(int n) {
        return (n & (n - 1)) == 0 && (n & (0x55555555)) != 0;

        // Intution
        // power of 4 will be power 2 as well but the power of 4 always has set bit at
        // even position (0 based index) so we take a hexadecimal number of
        // (ox55555555) which is get us 1 if it will be in even position
        // further explain in notebook
    }
}
