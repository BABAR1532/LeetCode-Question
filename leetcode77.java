class Solution {

   // Recursive method
   public static List<List<Integer>> backComb(int start,int n,ArrayList<Integer> path,int targetSize){

     // Base case
     if(path.size() == targetSize){

       List<List<Integer>> l = new ArrayList<>();

       l.add(new ArrayList<>(path));
       return l;
     }


     List<List<Integer>> ans = new ArrayList<>();

     for(int i = start; i <= n; i++){

       path.add(i);

       ans.addAll(backComb(i+1,n,path,targetSize));



       // BackTrack
       path.remove(path.size() - 1);

    }

    return ans;

   }


    public List<List<Integer>> combine(int n, int k) {

       return  backComb(1,n,new ArrayList<>(),k);


    }
}
