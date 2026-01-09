class Solution {
    public int longestOnes(int[] nums, int k) {

        int count = 0;
        int start = 0;

        int ans = 0;

        for(int end = 0; end < nums.length; end++){

           if(nums[end] == 1) count++;

           while((end - start + 1) - count > k){
             if(nums[start] == 1) count--;
             left++;
           }

           ans = Math.max(ans,end - start + 1);
        }

        return ans;
    }
}
