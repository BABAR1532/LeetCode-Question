class Solution {

  public static List<List<Integer>> sub(int start,int[] nums,List<Integer> path,List<List<Integer>> ans){
      ans.add(new ArrayList<>(path));

      for(int i = start; i < nums.length; i++){


         // Skipping dulplicated
         if(i > start && nums[i] == nums[i-1]) continue;

         path.add(nums[i]);

         // Recursive call
         sub(i+1,nums,path,ans);


         // Backtraking
         path.remove(path.size() - 1);

      }

      return ans;

  }


    public List<List<Integer>> subsetsWithDup(int[] nums) {


        Arrays.sort(nums);


         List<List<Integer>> ans = new ArrayList<>();

         sub(0,nums,new ArrayList<>(),ans);

        return ans;

    }

