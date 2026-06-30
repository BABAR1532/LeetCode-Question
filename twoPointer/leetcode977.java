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
