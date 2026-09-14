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
    public ListNode[] splitListToParts(ListNode head, int k) {
      ListNode tem=head;
      int count=0;
      while(tem!=null)
      {
        tem=tem.next;
        count++;
      }
      ListNode[] ans=new ListNode[k];
      ListNode temp=head;
      int i=0;
      int n=k;
      if(k>count)
      {
        k=count;
      }
      while(temp!=null)
      {
        if(count%k==0)
        {
            ans[i]=temp;
            i++;
            ListNode dummy=temp;
             for(int j=1; j<count/k; j++){
                    temp=temp.next;
             }
                dummy=temp;
                temp=temp.next;
                dummy.next=null;
            } 
            else{
                ans[i]=temp; i++;
                ListNode dummy = temp;
                for(int j=1; j<count/k +1; j++){
                    if(temp!=null){
                        temp=temp.next;
                    }
                }
                if(temp!=null){
                    dummy=temp;
                    temp=temp.next;
                    dummy.next=null;
                }
                count--;
            }
        }
        if(n>count){
            while(i<n){
                ans[i]=null;
                i++;
            }
        }
        return ans;
    }
}