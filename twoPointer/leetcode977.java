class Solution {
    public int[] sortedSquares(int[] nums) {

      int start = 0;
      int end = nums.length - 1;

      int[] arr  = new int[nums.length];
      int index = end;

      while(start <= end){

        // Finding square
        int sq1  = nums[start] * nums[start];
        int sq2 = Math.pow(nums[end],2);

        if(sq1 > sq2){

          arr[index] = sq1;
          left++;

        }

        else{

          arr[index] = sq1;
          end--;

        }

        index--;
      }


      return arr;

    }
}


///



class Solution {
  
  public void swap(int[] nums, int i, int j){
     int temp = nums[i];
     nums[i] = nums[j];
     nums[j] = temp;
  }
      
    public int[] sortedSquares(int[] nums) {
        
       int start = 0;
       int end = nums.length - 1;
       int index = nums.length - 1;

       int[] ans = new int[nums.length];

       while(start <= end){
          
          int val1 = nums[start] * nums[start];
          int val2 = nums[end] * nums[end];

              
          if(val1 > val2){
              ans[index--] = val1;
              start++;
          }  
          else{
            ans[index--] = val2;
            end--;
          }  

         
       }


       return ans;

    }
}
