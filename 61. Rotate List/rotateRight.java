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
        ListNode cur = head;
        ListNode prev = null;
        int size = 0;

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        while (cur != null) {
            cur = cur.next;
            size++;
        }

        cur = head;
        // link the head and the tail
        for (int i = 0; i < size - 1; i++) {
            cur = cur.next;
        }
        cur.next = head;

        prev = cur;
        cur = cur.next;

        for(int i = 0; i < size - (k % size); i++) {
            cur = cur.next;
            prev = prev.next;
        }

        prev.next = null;
        return cur;

    }
}