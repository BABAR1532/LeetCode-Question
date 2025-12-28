lass Solution {

    public int removeDuplicates(int[] nums) {



        int k = 1;


        int start = 0;

        int end = 1;


        while(end < nums.length){


          if(nums[start] != nums[end]){

            nums[start + 1] = nums[end];

            k++;

            start++;

          }



              end++;



        }


        return k;

    }

}
