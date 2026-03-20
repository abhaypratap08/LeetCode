/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // **First Pass: Interweave original and copied nodes**
        Node temp = head;
        while (temp != null) {
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = node.next;
        }

        // **Second Pass: Assign random pointers**
        temp = head;
        while (temp != null) {
            Node node = temp.next; // The copy
            // The copy's random pointer points to the next of the original's random pointer
            node.random = temp.random != null ? temp.random.next : null;
            temp = node.next; // Move to the next original node
        }

        // **Third Pass: Separate the two lists**
        temp = head;
        Node newHead = head.next;
        while (temp != null) {
            Node node = temp.next;
            // Restore original list's next pointer
            temp.next = node.next; 
            
            // Set copied list's next pointer
            if (node.next != null) {
                node.next = node.next.next;
            }
            
            // Move to the next original node
            temp = temp.next; 
        }
        
        return newHead;
    }
}