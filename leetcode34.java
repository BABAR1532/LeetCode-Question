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



class Solution {

  public static void search(int[] nums, int[] ans, int start, int end, int target){

      if(start > end) return;

      int mid = start + (end - start) / 2;

      if(target == nums[mid]){



          ans[0] = Math.min(ans[0],mid);
          and[1] = Math.max(and[1],mid);


          // Left call
          search(nums,ans,start,mid-1,target);
          // Right call
          search(nums,ans,mid+1,end,target);

         }

      }


      if(target < nums[mid]){
         end = mid - 1;
      }

      else if(target > nums[mid]){
        start = mid + 1;
      }

      search(nums,ans,start,end,target)

  }



    public int[] searchRange(int[] nums, int target) {


          int ans[] {Integer.MAX_VALUE,Integer.MIN_VALUE};


          // If no index found
          if(ans[0] == Integer.MAX_VALUE) return new int[]{-1,-1};


          search(nums,ans,0,nums.length - 1, target);

    }
}























