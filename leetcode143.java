class Solution {
    public void reorderList(ListNode head) {


      if(head == null || head.next = null) return head;



        ListNode fast = head;
        ListNode slow = head;


       while(fast != null && fast.next != null){


          slow = slow.next;
          fast = fast.next.next;

       }


      // Find the mid node
      ListNode p2 = reverseNode(slow.next);

      // left list
      slow.next = null;

      ListNode p1 = head;


      while(p2 != null){

          ListNode next1 = p1.next;
          ListNode next2 = p2.next;

          p1.next = p2;
          p2.next = next1;


          p1 = next1;
          p2 = next2;


         // current = current.next;
         // temp.next = mid;
         //
         // mid.next = current;
         //
         // temp = current;
         // mid = mid.next;
      }


    }


    // Reverse node code
    public static ListNode reverseNode(ListNode root){

          ListNode prev = null;
          ListNode current = root;
          ListNode next = root;

          while(next != null){

              next = current.next;
              current.next =  prev;
              prev = current;
              current = next;

          }

          return prev;


    }
