
import java.util.*;

class FrontMiddleBackQueue {

    Deque<Integer> left;
    Deque<Integer> right;

    public FrontMiddleBackQueue() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    public void pushFront(int val) {

        left.addFirst(val);

        // It is complusary
        rebalance();

    }

    public void pushMiddle(int val) {

        // Normal case
        if(left.size() == right.size()){
            // Simple push
            left.addLast(val);
        }
        else {

            // First popping middle element so we can add new middle element
            // Main thing
            right.addFirst(left.removeLast());

            // Then add the values
            left.addLast(val);

        }
    }

    public void pushBack(int val) {
        right.addLast(val);
        rebalance();
    }

    public int popFront() {

         if(isEmpty()) return -1;

         if(!left.isEmpty){
             int value = left.removeFirst();
             rebalance();
             return value;
         }
         else {

           int value = right.removeFirst();
           rebalance();
           return value;
         }

    }

    public int popMiddle() {
        if(!isEmpty()) return -1;

        int val = left.removeLast();
        rebalance();
    }

    public int popBack() {

         if(!isEmpty()) return -1;

         if(!right.isEmpty()){
           int val =  right.removeLast();
           rebalance();
           return val;
         }
         else{
           int value = left.removeLast();
           rebalance();
           return val;
         }

    }


    // Very important function it is like balancing the values
    private void rebalance() {

         if(left.size() > right.size() + 1){
              right.addFirst(left.removeLast());
         }

         else if(right.size() > left.size()){
              left.addLast(right.removeFirst());
         }

    }

    private boolean isEmpty() {

         return left.isEmpty() && right.isEmpty();
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */
