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
    public ListNode insertionSortList(ListNode head) {
        List <Integer> list=new ArrayList<>();

        ListNode temp=head;
        while(temp!=null){
            list.add(temp.val);
            temp=temp.next;
        }

        temp=head;
        Collections.sort(list);
        for(int i=0;i<list.size();i++){
            temp.val=list.get(i);
            temp=temp.next;
        }
        return head;
    }
}