class Solution {
    public int maxSubArray(int[] nums) {

        // We do inital setup
        // Peeking first element as max ending and res as well

        int maxEnding = nums[0];
        int res = num[0];

        for(int i = 1; i < nums.length; i++){

            // We just decide if the current value and last subarray all value is with current which is will give me max

            maxEnding = Math.max(maxEnding + nums[i],num[i]);


            // If we get some value which is greater

            res = Math.max(res,maxEnding);

        }



        return result;

    }
}
