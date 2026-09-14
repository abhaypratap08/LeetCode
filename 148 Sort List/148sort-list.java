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
    public ListNode sortList(ListNode head) {
        if (head == null) return null;

        int len = 0;
        ListNode copy = head;
        while (copy != null) {
            copy = copy.next;
            len ++;
        }

        return mergeSort(head, len);
    }

    private ListNode merge(ListNode A, ListNode B) {
        ListNode temp = new ListNode();
        ListNode copy = temp;

        while (A != null && B != null) {
            if (A.val < B.val) {
                temp.next = A;
                A = A.next;
            } else {
                temp.next = B;
                B = B.next;
            }

            temp = temp.next;
        }

        if (A != null) temp.next = A;
        if (B != null) temp.next = B;

        return copy.next;
    }

    private ListNode mergeSort(ListNode list, int len) {
        if (len == 1) return list;

        int limit = len / 2;

        ListNode copy = list;
        ListNode prev = list;
        for (int i = 0; i < limit; i ++) {
            prev = list;
            list = list.next;
        }
        prev.next = null;

        ListNode left = mergeSort(copy, limit);
        ListNode right = mergeSort(list, len - limit);

        return merge(left, right);
    }
}