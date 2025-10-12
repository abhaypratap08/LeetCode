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
    public ListNode modifiedList(int[] nums, ListNode head) {
        int[] hash = new int[100001];
        
        for(var i : nums){
            hash[i] = 1;
        }

        while(head != null && hash[head.val] == 1){
            head = head.next;
        }
        ListNode p = head;
        ListNode prev = null;

        while(p != null){
            if(hash[p.val] == 1) prev.next = p.next;
            else prev = p;

            p = p.next;
        }
        return head;
    }
}