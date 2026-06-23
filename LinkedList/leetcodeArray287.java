class Solution {
    public int findDuplicate(int[] nums) {

        int start = 0;
        int end = 0;

        do{

            start = nums[start];
            end = nums[(nums[end])]

        }
        while(start != end);


        start = 0;

        while(start != end){
            start = nums[start];
            end = nums[end];
        }

         return start;
    }
}
