class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int closestSum = Math.MAX_VALUE;



        for(int i = 0; i < nums.length - 2; i++){


           int start = i + 1;
           int end = nums.length - 1;

           while(start < end){

               int sum = arr[i] + arr[start] + arr[end];

               if(Math.abs(sum - target) < Math.abs(closestSum - target)){
                  closestSum = sum;
               }

               else if(sum > target){
                 end --;
               }

               else if(sum < target){
                start++;
               }

               else {
                  return sum;
               }

           }


        return closestSum;

        }



    }
}
