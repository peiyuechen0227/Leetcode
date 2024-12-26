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
    public ListNode reverseList(ListNode head) {
        ListNode cur = null;
        ListNode index = head;
        while (index != null) {
            cur = addNode(cur, index.val);
            index = index.next;
        }
        return cur;
    }
    public ListNode addNode(ListNode cur, int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = cur;
        return newNode;
    }
}

// Solution 2
//class Solution {
//    public ListNode reverseList(ListNode head) {
//        ListNode cur = head;
//        ListNode prev = null;
//        LisrNode temp = null;
//        while (cur != null) {
//             temp = cur.next;
//             cur.next = prev;
//             prev = cur;
//             cur = temp;
//         }
//        return prev;
//    }
//}

// Solution 3
//class Solution {
//    public ListNode reverseList(ListNode head) {
//
//    }
//    public ListNode reverse(LisrNode prev, ListNode cur) {
//        if (cur == null) {
//            return prev;
//        }
//        Linklist temp = cur.next;
//        cur.next = prev;
//        reverse(cur, temp);
//    }
//}