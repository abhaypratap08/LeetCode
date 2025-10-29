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
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int prefix = 0;
        for (ListNode cur = dummy; cur != null; cur = cur.next) {
            prefix += cur.val;
            map.put(prefix, cur);
        }
        prefix = 0;
        for (ListNode cur = dummy; cur != null; cur = cur.next) {
            prefix += cur.val;
            cur.next = map.get(prefix).next;
        }

        return dummy.next;
    }
}
