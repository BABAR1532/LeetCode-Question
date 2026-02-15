class Solution {

    // Method to check our bouquet is possible
    public static boolean canMake(int[] arr,int k, int key,int m){

        int count = 0;
        int bouquet = 0;

        for(int i = 0; i < arr.length; i++){

            if(arr[i] <= key){

               count++;

               if(count == k){
                   bouquet++;
                   count = 0;
               }

            }
            else{
                 count = 0 // adjacency broken
            }
        }

         return bouquet >= m;
    }



    public int minDays(int[] bloomDay, int m, int k) {

     // Edge case
     if(m * k  > bloomDay.length) return -1;

     int start = 1;
     int end = 0;

     // Caculating maximum day required to bloom
     for(int i = 0; i < bloomDay.length; i++){
         end = Math.max(end,bloomDay[i]);
     }

     int ans = end;

     while(start <= end){

         int mid = start + (end - start) / 2;

         if(canMake(bloomDay,k,mid,m)){
             ans = mid;
             end = mid - 1; // Trying smaller value
         }
         else{
             start = mid + 1;
         }
     }

     return ans;

    }
}
