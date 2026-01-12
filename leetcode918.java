class Solution {
    public int maxSubarraySumCircular(int[] nums) {


        int totalSum = 0;

        int minTotal = nums[0];
        int maxTotal = nums[0];

        int currentMax = 0;
        int currentMin = 0;



        for(int value : nums){

            // Normal Kadane
             currentMax = Math.max(value,value+currentMax);
             maxTotal = Math.max(maxTotal,currentMax);


            // Min Kadane
            currentMin = Math.min(value,value+currentMin);
            minTotal = Math.min(minTotal,currentMin);

            totalSum += value;

        }


        if(totalSum == minTotal){
           return maxTotal;
        }


        return Math.max(maxTotal, totalSum - minTotal);

    }
}
