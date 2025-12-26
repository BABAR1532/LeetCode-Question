class Solution {


    public static void combi(int start,int sum,int[] arr,ArrayList<Integer> path,int target, List<List<Integer>> ans){

     if(sum == target){
            ans.add(new ArrayList<>(path));
       }


    for(int i = start; i < arr.length; i++){


         if((sum + arr[i]) > target) break;


         path.add(arr[i]);


         combi(i,arr[i] + sum,arr,path,target,ans);


         // Backtracking
         path.remove(path.size() - 1);

    }

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {


         // Sort the array
         Arrays.sort(candidates);

         List<List<Integer>> ans = new ArrayList<>();


         // Recursive call
         combi(0,0,candidates,new ArrayList<>(),target,ans);



        return ans;
    }

}
