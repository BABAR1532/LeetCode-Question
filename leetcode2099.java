class Solution {
    public int[] maxSubsequence(int[] nums, int k) {

        // Using priority queue
        // It is max heap because we will poll min element which will if pq.length > k
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

  
       // OR
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
//     if (a[0] == b[0]) return a[1] - b[1];
//     return a[0] - b[0];
// });




       // Traversing from each value
        for(int i = 0; i < nums.length; i++){

        	pq.offer(new int[]{nums[i],i});


        	// Very important to maintain whole array

        	if(pq.size() > k){
        		pq.poll();
        	}
        }
       



        // List for indexing sorting
        List<Int[]> list = new ArrayList<>(pq);


        // Sorting
        List.sort(Comparator.comparingInt(a -> a[1]));



        // Buidling you final ans
        int ans[] = new int[k];

        for(int i = 0; i < k; i++){

        	ans[i] = (list.get(i)[0]);
        }

        return ans;



    }
}
