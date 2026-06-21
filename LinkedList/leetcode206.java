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

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

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
}
