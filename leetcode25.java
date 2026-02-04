/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null && k = 1) return head;


        ListNode dummy = new ListNode(-1);

        dummy.next = head;

        ListNode prevNodeEnd = dummy;

        while(true){

         ListNode  kthNode = prevNodeEnd;

         for(int i = 0; i < k &&  kthNode != null; i++){
             kthNode = kthNode.next;
         }


         if(kthNode == null) break;


         ListNode GroupStart = prevNodeEnd.next;

         // Indicate next Group
         ListNode nextGroupStart = kthNode.next;


         ListNode prev = nextGroupStart;
         ListNode current = GroupStart;

         // Reverse node

         while(current  != nextGroupStart){
           ListNode temp = current.next;
           current.next = prev;
           prev = current;
           current = temp;
         }



         // Reconnection
         prevNodeEnd.next = kthNode;
         prevNodeEnd = GroupStart;

        }


           return dummy.next;

    }
}
