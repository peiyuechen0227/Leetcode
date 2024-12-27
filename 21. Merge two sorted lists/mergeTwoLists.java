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
        ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode dummy1 = new ListNode(0, list1);
        ListNode prev = dummy1;
        ListNode temp = null;

        while (node1 != null && node2 != null) {
            if (node2.val <= node1.val) {
                temp = node2.next;
                node2.next = node1;
                prev.next = node2;
                // move prev
                prev = node2;
                node2 = temp;
            }
            else {
                prev = node1;
                node1 = node1.next;
            }
        }

        if (node2 != null) {
            prev.next = node2;
        }
        return dummy1.next;
    }
}