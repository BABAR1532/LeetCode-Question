class FrontMiddleBackQueue {

      Deque<Integer> left;
      Deque<Integer> right;


    public FrontMiddleBackQueue() {

         // Giving memory to both deque
         left = new ArrayDeque<>();
         right = new ArrayDeque<>();

    }

    public void pushFront(int val) {

         left.addFirst(val);
         rebalance();   // -> compulsary
    }

    public void pushMiddle(int val) {

        // if left = right (deque)
        if(left.size() == right.size()){
          left.addLast(val);
        }
        else {

            right.addFirst(left.removeLast());
            left.addLast(val);

        }

    }

    public void pushBack(int val) {
        right.addLast(val);
        rebalance();
    }

    public int popFront() {

        if(isEmpty()) return -1;

        int val;

        // If left is not empty (-> edge cases normal it will work)
        if(!left.isEmpty()) val = left.removeFirst();
        else val = right.removeFirst();

        // compulsary
        rebalance();

        return val;

    }

    public int popMiddle() {

      if(isEmpty()) return -1;

      int val = left.removeLast();


//       // If left become small
//       if(left.size() < right.size()){
//
//           left.addLast(right.removeFirst());
//       }
//


       // Direct method
       rebalance();

       return val;

    }

    public int popBack() {

        if(isEmpty()) return -1;

        int val;

        if(right.isEmpty()) val = right.removeLast();
        else val = left.removeLast();

        // rebalance
        rebalance();


    }

    // Helper Function
     private void rebalance(){

        if(left.size() > right.size() + 1){

          right.addFirst(left.removeLast());

        }
        else if(right.size() > left.size()){

           left.addLast(right.removeFirst());

        }

     }


     // Checking is Empty

     private boolean isEmpty(){

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
