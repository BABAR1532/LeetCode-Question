class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        int left = 0;

        int product = 1;
        int count = 0;

        for(int right = 0; i < nums.length; right++){

            product *= nums[right];


            while(product >= k){

              // Shrinking the window
              product /= nums[left];
              left++;

            }

            count += (right - left + 1);
        }

        return count;

    }
}
