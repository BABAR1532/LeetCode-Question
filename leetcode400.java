class Solution {
    public int findNthDigit(int n) {

         long countLength = 1;
         long digit = 9;
         long start = 1;


         while(n > digit * countLength){

           n -= digit * countLength;

           countLength++;
           digit *= 10;
           start *= 10;
         }


         // Getting exact number
         long number = start + (n - 1) / countLength;


         // Getting exact position
         int position = (int)((n - 1) % countLength);


         return String.valueOf(number).charAt(position) - '0';

    }
}
