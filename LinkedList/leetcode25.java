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

    public ListNode reverse(ListNode head, ListNode group) {
        ListNode dummy = null;
        ListNode next = head;

        while (head != group) {
            next = head;
            head = head.next;
            next.next = dummy;
            dummy = next;
        }

        return dummy;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head.next == null || k == 1) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode next = dummy;

        while (next != null) {
            ListNode firstNode = next.next;

            for (int i = 0; i < k; i++) {
                next = next.next;
                if (next == null) return dummy.next;
            }

            ListNode nextGroup = next.next;
            ListNode temp = reverse(prev.next, nextGroup);

            prev.next.next = nextGroup;
            prev.next = temp;

            next = firstNode;
            prev = firstNode;
        }

        return dummy.next;
    }
}
