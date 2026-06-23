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

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);

        ListNode smallerNode = dummy1;
        ListNode largerNode = dummy2;

        ListNode temp = head;

        while (temp != null) {
            ListNode next = temp.next;
            temp.next = null;

            if (temp.val < x) {
                smallerNode.next = temp;
                smallerNode = smallerNode.next;
            } else {
                largerNode.next = temp;
                largerNode = largerNode.next;
            }

            temp = next;
        }

        smallerNode.next = dummy2.next;

        return dummy1.next;
    }
}
