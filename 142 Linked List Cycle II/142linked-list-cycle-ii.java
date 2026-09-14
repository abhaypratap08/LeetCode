/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<>();
        return find(head, seen);
    }

    private ListNode find(ListNode node, Set<ListNode> seen) {
        if (node == null) return null;
        if (seen.contains(node)) return node;
        seen.add(node);
        return find(node.next, seen);
    }    
}