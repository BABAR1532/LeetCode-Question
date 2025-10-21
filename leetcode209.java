class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;


        for(int right = 0; i < nums.length; i++){

            sum += nums[i];

            // Checking if sum is >= target

            while(sum >= target){

              // Update the subarray index range
              minLen = Math.min(minLen,right - left + 1);

              sum -= nums[left];

              // Since we remove left array value from our window
              left++;

            }

        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;


    }
}
