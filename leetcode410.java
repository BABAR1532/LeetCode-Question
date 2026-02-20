class Solution {

    public static int split(int nums[], int key){

        int count = 1;
        int added =  0;

        for(int i = 0; i < nums.length; i++){

            if(added  + nums[i] > key){
                count++;
                added = nums[i];
            }
            else{
                added += nums[i];
            }
        }

     return count;

    }

    public int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;

        for (int num : nums) {
            end += num;
            start = Math.max(start,num);
        }

        int ans = 0;

        while(start <= end){
            int mid = start + (end - start) /2

            if( split(nums,k,mid) ==  k){

                end = mid - 1;
                ans = mid;
            }
            else{
                start = mid + 1;
            }

        }

        return ans;

    }
}
