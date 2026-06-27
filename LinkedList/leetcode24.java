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

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);

        dummy.next = head;

        ListNode prev = dummy;
        ListNode next = head;

        while (next != null || next.next != null) {
            prev.next = next.next;
            next.next = prev.next.next;
            prev.next.next = next;

            prev = next;
            next = prev.next;
        }

        return dummy.next;
    }
}
