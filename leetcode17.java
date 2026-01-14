class Solution {


   public static ArrayList<String>  backtrack(String proceed,String unProcessed){

      if(unProcessed.isEmpty()){
         ArrayList<String> list = new ArrayList<>();
         list.add(proceed);
         return list;
      }


      int value = unProcessed.charAt(0) - '0';


      ArrayList<String> ans = new ArrayList<>();

      int start = (value - 2) * 3;
      int end = (value - 1) * 3;

      if(value == 7){
        end = start + 4;
      }

      if(value == 8){

        start = 19;
        end = 22;
      }

      if(value == 9){
         start = 22;
         end = 26;
      }


      for(int i =  start; i < end; i++){

          char ch = (char) ('a' + i);
          ans.addAll(backtrack(proceed + ch, unProcessed.substring(1)));

      }
      return ans;
   }



    public List<String> letterCombinations(String digits) {


        return backtrack("",unProcessed);


    }
}
