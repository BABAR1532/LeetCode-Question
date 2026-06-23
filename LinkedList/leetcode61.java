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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || (head.next = null || k == 0)) return head;

        ListNode temp = head;

        int size = 0;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int round = k % size;

        if (rount == 0) return head;

        round = size - rount;

        temp = head;

        for (int i = 0; i < round; i++) {
            temp = temp.next;
        }

        ListNode newHead = temp.next;
        temp.next = null;

        ListNode temp2 = newHead;

        while (temp2 != null) {
            temp2 = temp2.next;
        }

        temp2.next = head;

        return newHead;
    }
}
