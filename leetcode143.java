// class Solution {
//     public int pivotIndex(int[] nums) {
//
//      // Calcuating array sum
//       int sum = 0;
//
//      for(int value:nums){
//          sum += value;
//      }
//
//
//     for(int i = 1; i < nums.length; i++){
//
//      left += nums[i-1];
//      right = sum - (nums[i] + left);
//
//       if(left == right) return i;
//     }
//
//      return -1;
//
//     }
// }

int n = 0;

int count = 0;

for(int i = 2; i < n; i++){

   if(n % 2 == 0){
       n = n / 2;
       count++;
   }

   if(n % 3 == 0){
      n = n/2;
      count++;
   }

  else {
    count++;
    break;
  }
}
