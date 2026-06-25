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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;

        while (l1 != null || l2 != null || carry != 0) {
            int total = 0;
            if (l1 != null && l2 != null) {
                total = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l2 != null) {
                total = l2.val + carry;
                l2 = l2.next;
            } else if (l1 != null) {
                total = l1.val + carry;
                l1 = l1.next;
            } else {
                total = carry;
            }

            ListNode newNode = new ListNode(total % 10);
            ans.next = newNode;
            ans = ans.next;

            carry = total / 10;
        }

        return dummy.next;
    }
}
