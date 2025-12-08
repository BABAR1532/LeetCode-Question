class Solution {
    public int countPrimes(int n) {


         if(n <= 2) return n;



         // Array for finding Values
         boolean[] arr = new boolean[n];


         for(int i = 2; i*i < n; i++){

            if(arr[i]) continue;

            for(int j = i * i; j < arr.length; j += i){

                 arr[j] = true;

            }
         }

         int count = 0;

         for(int i = 2; i < arr.length; i++){

          if(!arr[i]){
             count++;
           }
         }


         return count;


    }
}
