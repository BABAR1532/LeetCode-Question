class Solution {

   public static List<List<Integer>> per(int[] processed,int[] unprocessed){

     if(unprocessed.length == 0){

       List<List<Integer>> l = new ArrayList<>();
       l.add(new ArrayList<>(processed));
       return l;
     }

      List<List<Integer>> ans = new ArrayList<>();

      int a = unprocessed[0];


      int[] remaining = Arrays.copyOfRange(unprocessed,1,unprocessed.length);


      for(int i = 0; i <= processed.length; i++){

       List<Integer> list = new ArrayList<>();

         list.add(i,a);

        and.addAll(per(processed,remaining));

     }

     return ans;

   }


    public List<List<Integer>> permute(int[] nums) {


    List<Integer> arr = new ArrayList<>();

      return per(arr,nums);


    }
}
