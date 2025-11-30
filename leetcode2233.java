class Solution {
    public int maximumProduct(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();


       // Adding value in priortiy Queue

        for(int i = 0 ; i < nums.length; i++){

            pq.offer(nums[i]);

        }


       // Increment value one by one

       for(int i = 0; i < nums.length; i++){


            int SmallValue = pq.peek();

            // Increment the value
            SmallValue++;

            pq.offer(SmallValue);

       }


       int ans = 1;



       // Add the value

       for(int i = 0; i < nums.length; i++){

          ans *= pq.poll();
       class Solution {
    public int maximumProduct(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();


       // Adding value in priortiy Queue

        for(int i = 0 ; i < nums.length; i++){

            pq.offer(nums[i]);

        }


       // Increment value one by one

       for(int i = 0; i < k; i++){


            int SmallValue = pq.poll();

            // Increment the value
            SmallValue++;

            pq.offer(SmallValue);

       }


       long ans = 1;
       long mod = 1_000_000_007;



       // Add the value

       for(int i = 0; i < nums.length; i++){

          ans =  (ans * pq.poll()) % mod;

       }


      return (int) ans;




 }

 }
