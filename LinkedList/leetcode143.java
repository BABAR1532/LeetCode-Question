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

    public void reverse(ListNode head) {
        ListNode dummy = null;
        ListNode next = head;

        while (next != null) {
            ListNode temp = next;
            next = next.next;
            temp.next = dummy;
            dummy = temp;
        }
    }

    public void reorderList(ListNode head) {
        // Edge case
        if (head.next == null || head.next.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = merge(slow.next);
        slow.next = null;

        ListNode first = head;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}
