class Solution {
    public int removeDuplicates(int[] nums) {

              int n = nums.length;
          int slow = 0;
          int fast = 0;


          while(fast < n){

              int start = fast;

              while(fast < n && nums[start] == nums[fast]){
                  fast++;
              }

              int count = fast - start;

              int copies = Math.min(2,count);


              for(int i = 0; i < copies; i++){
                   nums[slow++] = nums[start];
              }


          }

          return slow;
}


// Another appoarch


class Solution {
    public int removeDuplicates(int[] nums) {

        if(nums.length <= 2){
            return nums.length;
        }

       int slow = 2;

        for(int fast = 2; fast < nums.length; fast++){

            if(nums[fast] != nums[slow -2]){
                nums[slow] = nums[fast];
                slow++;
            }
        }

       return slow;
    }
}










