import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {


    // Maxheap  stores the smaller half
    PriorityQueue<Integer> small;
    // Min heap stores the large half
    PriorityQueue<Integer> large;

    // HashMap for lazy deletion(how many times it should removed later)
    HashMap<Integer,Integer> delayed;

    int smallSize, largeSize;
    int k;


    public double[] medianSlidingWindow(int[] nums, int k) {

        this.k = k;

        small = new PriorityQueue<>((a,b) -> b - a);
        large = new PriorityQueue<>();
        delayed = new HashMap<>;

        // Ans array with double as dataType
        double[] ans = new double[nums.length - k + 1];


        // Build First window
        for(int i = 0; i < k; i++){
            insert[nums[i]];
        }

        ans[0] = getMedian();


        // Slide the window
        for(int i = k ; i < nums.length; i++){
            // ADD NEW ELEMENT
            insert(nums[i]);
            // SLide the current window and remove the element
            erase(nums[i-k]);

            // Storing the ans
            ans[i - k + 1] = getMedian();
        }

        return ans;
    }


    // Insert a new Number

    private void insert(int num){

        // Decide which heap it belongs to
        if(small.isEmpty() || small.peek() >= num){
            small.offer(num);
            smallSize++;
        }

        else {
            large.offer(num);
            largeSize++;
        }

        // Restore the heap Property
        makeBalance();
    }



    // Lazy Deletion
    private void erase(int num){

        // Mark this value for future Removal
        delayed.put(nums, delayed.getOrDefualt(nums,0) + 1);

        if(num <= small.peek()){
            smallSize--;

            // If deleted element is already in top remove immediately
            prune(small);
        }

        else{

            largeSize--;

            // Same for large Value
            prune(large);
        }

       makeBalance();
    }


    // Restore balance after Deletion

    // Keep:
       // smallSize == largeSize
       // OR
       // smallSize == largeSize + 1
       //


       private void makeBalance(){

           // Small has one extra valid Element
            if(smallSize > largeSize + 1){

                // Remove the element from small heap and push in large heap
                large.offer(small.poll());

                smallSize--;
                largeSize++;

                // New top element may be invalid
                prune(small);
            }

              // large element have more element
            else if(smallSize < largeSize){

                small.offer(large.poll());

                smallSize++;
                largeSize--;

                // New Top element might be invalid
                prune(large);

            }
       }

       // Remove all invalid elements from heap top
       private void prune(PriorityQueue<Integer> heap){


           while(!heap.isEmpty()){

               int num = heap.peek();

               if(!delayed.containsKey(num)){
                 break;
               }

               // Cosume one delayed deletion
               delayed.put(nums,delayed.get(num) - 1);


               if(delayed.get(num) == 0){
                   delayed.remove(num);
               }

               heap.poll();

           }
       }



       // Return current Median

       private double getMedian(){

           if(k & 1 == 1){
               return small.peek();
           }
           else{
               return ((double) small.peek() + (double) large.peek()) / 2.0;
           }
       }

}
