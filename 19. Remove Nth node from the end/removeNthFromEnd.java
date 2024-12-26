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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if (slow.next != null) {
            slow.next = slow.next.next;
        }
        return dummy.next;
    }
}
// time complexity: O(n)
// space comlexity: O(1)

// Solution 2
//class Solution {
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        Stack<ListNode> stack = new Stack<>();
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//
//        ListNode cur = dummy;
//        while (cur != null) {
//            stack.push(cur);
//            cur = cur.next;
//        }
//
//        for (int i = 0; i < n; i++) {
//            stack.pop();
//        }
//
//        ListNode prev = stack.peek();
//        prev.next = prev.next.next;
//
//        return dummy.next;
//    }
//}
// time complexity: O(n)
// space complexity: O(n)