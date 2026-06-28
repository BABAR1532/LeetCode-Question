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

    public void reverse(ListNode head, ListNode end) {
        ListNode dummy = null;
        ListNode next = head;

        while (head != end) {
            next = head;
            head = head.next;
            next.next = dummy;
            dummy = next;
        }
    }

    public ListNode reverseEvenLengthGroups(ListNode head) {
        if (head.next == null || head.next.next == null) return head;

        ListNode prev = head;
        ListNode next = head;

        int count = 1;

        while (next.next != null) {
            count++;

            int newCount = 0;

            for (int i = 0; i < count && next.next != null; i++) {
                next = next.next;
                newCount++;
            }

            if ((newCount & 1) != 0) {
                prev = next;
                continue;
            }

            // Storing nextGroup first node
            ListNode nextGroup = next.next;
            // Storing previous group last node
            ListNode temp = prev.next;

            // Reversing
            reverse(prev.next, nextGroup);

            temp.next = nextGroup;
            prev.next = next;

            prev = temp;
            next = temp;
        }

        return head;
    }
}
