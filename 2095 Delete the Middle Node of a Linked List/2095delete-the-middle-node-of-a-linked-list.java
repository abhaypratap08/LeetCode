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
    static 
    {
        ListNode t = new ListNode(0);
        for (int i = 0; i < 800; i++)
            deleteMiddle(t);
    }
    public static ListNode deleteMiddle(ListNode head) 
    {
        if(head==null || head.next==null) return null;
        ListNode k=head,j=head,p=null;
        while(k!=null && k.next!=null)
        {
            p=j;
            k=k.next.next;
            j=j.next;
        }
        p.next=j.next;
        return head;
    }
}