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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode first = head;
        dummy.next = head;
        ListNode second = null;
        ListNode prev = dummy;

        while (first != null && first.next != null) {
            second = first.next;
            first.next = second.next;
            second.next = first;
            prev.next = second;
            prev = first;
            first = first.next;
        }
        return dummy.next;
    }
}

//Solution 2
class Solution {
    public ListNode swapPairs(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next;
        ListNode newNode = swapPairs(next.next);

        // swap
        next.next = head;
        head.next = newNode;
        return next;
    }
}