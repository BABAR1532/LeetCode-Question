class Solution {

   // Two sum

   public static void twoSum(int start,int end, int[] nums,List<List<Integer>> ans, int fixed){

      while(start < end){

       // Calcuating sum
       int sum = nums[start] + nums[end] + fixed;

       if(sum == 0){

          // Creating list to store ans
          List<Integer> list = new ArrayList<>(List.of(nums[start],nums[end],fixed));
          ans.add(list);


          while(start < end && nums[start] == nums[start + 1]) start++;
          while(start < end && nums[end] == nums[end - 1]) end--;


           // Normal pointer increment
           start++;
           end--;
       }


       else if(sum > 0){
         end--;
       }

       else {
           start++;
       }

      }

   }


    public List<List<Integer>> threeSum(int[] nums) {

        // Sorting array
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();


        for(int i = 0; i < nums.length - 2; i++){


         if(i > 0 && nums[i] == nums[i-1]) continue;



           // Fixed value
           int fixed = nums[i];


           int start = i+1;
           int end = nums.length - 1;

           // solving using 2 sum approach
           twoSum(start,end,nums,ans,fixed);


        }

        return ans;
    }
}
