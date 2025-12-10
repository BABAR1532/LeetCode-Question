// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//
//         int[] arr = {-1,-1};
//
//         int count = 0;
//
//         for(int i = 0; i <  nums.length; i++){
//
//            if(nums[i] == target){
//
//               arr[0] = i;
//               i++;
//
//              while(nums[i] == target){
//
//                 count = i;
//                 i++;
//
//              }
//            }
//         }
//
//
//         if(arr[0] != -1 && count > 0){
//
//          arr[1] = count;
//         }
//
//         else if(arr[0] == -1 && count == 0){
//
//          arr[1] = arr[0];
//
//         }
//
//
//         return arr;
//
//     }
// }



























