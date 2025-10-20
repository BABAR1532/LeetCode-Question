class leetcode621 {
    public int leastInterval(char[] tasks, int n) {

         // using hashmap to count each task frequency
         Map<Character,Integer> freq = new HashMap<>();

         for(char c:tasks){

             freq.put(c, freq.getOrDefault(c, 0) + 1);
         }


        // Step 2: Create a max heap (highest frequency first)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(freq.values());

        // Step 3: Queue to track cooldowns
        // Each element = int[]{remaining_count, time_when_available}
        Queue<int[]> waitQueue = new LinkedList<>();

        int time = 0;


        while(!maxHeap.isEmpty() || !waitQueue.isEmpty()){
              time++;

              // Pick task with highest count
              if(!maxHeap.isEmpty()){

                  int count = maxHeap.poll() - 1;

                  if(count > 0){
                      // Add to queue after removing from max heap
                      waitQueue.add(new int[]{count,time+n+1});
                  }
              }

              // Checking in queue
            if(!waitQueue.isEmpty() && waitQueue.peek()[1] == time){

                 // Adding back to heap
                 maxHeap.add(waitQueue.poll[0]);
            }



        }


         return time;


    }
}
