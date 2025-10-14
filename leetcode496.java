class Solution {

   public static int nextGreat(int[] nums2,int key){

    // Get index


    int index = -1;

    for(int i = 0; i < nums2.length; i++){

       if(nums2[i] == key){

         index = i;
       }
    }

      for(int i  = index+1; i < nums2.length; i++){

         if(nums2[i] > key){
            return nums2[i];

         }
      }

      return -1;

   }


    public int[] nextGreaterElement(int[] nums1, int[] nums2) {


        int[] ans = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++){

          ans[i] = nextGreat(nums2,nums1[i]);

        }

        return ans;

    }
}
