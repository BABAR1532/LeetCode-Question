class Solution {
    public boolean isPowerOfThree(int n) {

        // if Number is less than or equal to 0
         if(n <= 0) return false;

        return powerThree(n);
    }

    boolean powerThree(int n){
       // Base Case
        if(n == 1){
            return true;
        }

        // if number is not divisible by 3
        if(n % 3 != 0) return false;

        // recrusive call
        return powerThree(n / 3);

    }
}