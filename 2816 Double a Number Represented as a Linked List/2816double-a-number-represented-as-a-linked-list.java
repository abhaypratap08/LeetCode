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
    public int twice(ListNode head){
        if (head == null){
            return 0;
        }
        int doublee = head.val * 2 + twice(head.next);
        head.val = doublee % 10;

        return doublee/10;
    }

    public ListNode doubleIt(ListNode head) {
        int carry = twice(head);
        if (carry != 0){
            head = new ListNode(carry, head);
        }
        return head;
    }
}







