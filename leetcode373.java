class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {


          // First i will create list and return if for edge cases
          List<List<Integer>> result = new ArrayList<>();

          if(nums1.length == 0 || nums2.length == 0 || k == 0) return result;


          // We are creating min heap but with some custom sorting
          PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a,b) -> (a[0] + a[1]) - (b[0] + b[1])
          );


          // Add first element of nums2 with element of k or size times
          for(int i = 0; i < Math.min(nums1.length,k); i++){
              // Seeding
              minHeap.offer(new int[]{nums1[i],nums2[0],0});
          }



          // Growing
          while(!minHeap.isEmpty() || k > 0){


             // First i will pull smallest pair
             int[] cur = minHeap.poll();

             int a = cur[0], b = cur[1], j = cur[2];

             result.add(Arrays.asList(a,b));

             // push next elment in nums[2] for same num[i] -> num[i] become constant
             if(j + 1 < nums2.length){
                minHeap.offer(new int[]{a,nums2[j+1],j+1});
             }
          }



          return result;



    }
}
