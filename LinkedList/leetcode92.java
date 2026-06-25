import jdk.internal.classfile.components.ClassPrinter.ListNode;

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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null) return head;

        if (left == right) return head;

        ListNode nakli = new ListNode(-1);

        nakli.next = head;

        ListNode temp = nakli;

        for (int i = 0; i < left - 1; i++) {
            temp = temp.next;
        }

        ListNode leftBefore = temp;

        temp = head;

        for (int i = 0; i < right; i++) {
            temp = temp.next;
        }

        ListNode rightAfter = temp;

        ListNode newHead = leftBefore.next;
        ListNode dummy = null;
        ListNode nex = newHead;

        // Reversing the link list
        while (nex != rightAfter) {
            newHead = nex;
            nex = nex.next;
            newHead.next = dummy;
            dummy = newHead;
        }

        leftBefore.next.next = rightAfter;
        leftBefore.next = dummy;

        return nakli.next;
    }
}
