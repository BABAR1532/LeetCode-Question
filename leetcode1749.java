class Solution {
    public int maxAbsoluteSum(int[] nums) {



       int minSum = nums[0];
       int maxSum = nums[0];

       int ans = 0;

       for(int i = 0; i < nums.length; i++){

           // Min sum
           minSum = Math.min(minSum,nums[i] + minSum);


           // Max sum
           maxSum = Math.max(maxSum,nums[i] + maxSum);

           int max = Math.max((Math.abs(minSum)),maxSum);

           ans = Math.max(ans,max);


       }

       return ans;


    }

}
