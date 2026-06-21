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

    public ListNode reverse(ListNode head) {
        ListNode dummy = null;
        ListNode temp = head;

        while (head != null) {
            temp = head;
            head = head.next;
            temp.next = dummy;
            dummy = temp;
        }

        return dummy;
    }

    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;

        int count = 0;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            count++;
        }

        // Reversing the last half part

        ListNode start = null;

        if ((count & 1) == 0)) {
            start = slow;
        } else {
            start = slow.next;
        }
        start = reverse(start);

        // Then we check

        slow = head;

        while (start != null) {
            if (slow.val != start.val) return false;

            start = start.next;
            slow = slow.next;
        }

        return true;
    }
}
