/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        // No need for this line it will automatically detect by floyd algorithm
        if (head.next == head) return head;

        ListNode slow = head;
        ListNode fast = head;

        boolean flag = false;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                flag = true;
                break;
            }
        }

        if (!flag) return null;

        slow = head;

        // Last floyd cycle check
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
