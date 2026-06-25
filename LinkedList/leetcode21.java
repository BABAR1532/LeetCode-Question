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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummy = new ListNode(-1);
        ListNode start = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                start.next = list1;
                list1 = list1.next;
                start = start.next;
            } else if (list2.val < list1.val) {
                start.next = list2;
                list2 = list2.next;
                start = start.next;
            }
        }

        if (list1 == null) {
            start.next = list2;
        } else {
            start.next = list1;
        }

        return dummy.next;
    }
}
