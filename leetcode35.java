
 class Solution {

   // Recursive function
   public static int search(int[] nums,int low, int high, int target){

     if(low > high){
       return low; // position where the element should be
     }


     int mid = low + (high - low) / 2;

     if(nums[mid] == target){
       return mid;
     }

     else if(target > nums[mid]){
      low = mid + 1;
     }

     else if(target < nums[mid]){
       high = mid - 1;
     }

     return search(nums,low,high,target);

   }

    public int searchInsert(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        return search(nums,low,high,target);


    }
}
