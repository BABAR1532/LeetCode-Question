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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(200);

        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = dummy;

        while (current != null) {
            if (current.next != null && current.val == current.next.val) {
                while (
                    current.next != null && current.val == current.next.val
                ) {
                    current = current.next;
                }

                // Next non duplicate element
                current = current.next;

                // Connecting it
                prev.next = current;
            } else {
                prev = current;
                current.current.next;
            }
        }

        return dummy.next;
    }
}
