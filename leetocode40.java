class Solution {


   // Method to check array == target

    public static boolean checkSum(ArrayList<Integer> arr,int target){

        int sum = 0;

        for(int i = 0; i < arr.size(); i++){

           sum += arr[i];

        }

        return sum == target ? true : false;
    }



   public static void subset(int start, int[] arr, ArrayList<Integer> ans, List<List<Integer> ans2,int target){

          // If sum of element total to target

          if(ans,Target) {
             ans2.add(new ArrayList<>(ans));
          }


          for(int i = start; i < arr.length; i++){


            // Stopping pruning
            if(start > 0 && arr[i] == arr[i-1]) continue;

            // Adding values
            ans.add(i,arr[i]);

            // Calling
            subset(++start,arr,ans,ans2,target);


            // BackTracking
            ans.remove(ans.size() - 1);

          }

   }



    public List<List<Integer>> combinationSum2(int[] candidates, int target) {


         ArrayList<Integer> ans = new ArrayList<>();
         List<List<Integer> FinalAns = new ArrayList<>();

         subset(0,candidates,ans,FinalAns,target);

         return ans;

    }
}
