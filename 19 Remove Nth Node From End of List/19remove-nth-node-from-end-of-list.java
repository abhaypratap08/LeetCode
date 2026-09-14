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
        ListNode dummy = new ListNode(0, head);
        ListNode x = dummy;
        ListNode y = dummy;
        for (int i = 0; i <= n; i++) {
            x= x.next;
        }
        while (x!= null) {
            x = x.next;
            y =y.next;
        }
        y.next = y.next.next;
        return dummy.next;
    }
}