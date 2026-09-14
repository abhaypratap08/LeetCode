class ListNode {

int key;   // store key to remove from map during eviction
int val;   // cache value

ListNode prev;  // previous node in DLL
ListNode next;  // next node in DLL

ListNode(int key, int val) {
    this.key = key;
    this.val = val;
}
}

class LRUCache {

int capacity;

// Dummy nodes simplify insertion/deletion
ListNode head = new ListNode(-1, -1);
ListNode tail = new ListNode(-1, -1);

// HashMap for O(1) key access
Map<Integer, ListNode> map;

public LRUCache(int capacity) {

    this.capacity = capacity;
    this.map = new HashMap<>();

    // Connect dummy nodes
    head.next = tail;
    tail.prev = head;
}

// -------------------------------------
// Add node right after head (MRU)
// -------------------------------------
public void addNode(ListNode node) {

    ListNode nextNode = head.next;

    head.next = node;
    node.prev = head;

    node.next = nextNode;
    nextNode.prev = node;
}

// -------------------------------------
// Remove node from DLL
// -------------------------------------
public void deleteNode(ListNode node) {

    ListNode prevNode = node.prev;
    ListNode nextNode = node.next;

    prevNode.next = nextNode;
    nextNode.prev = prevNode;
}

// -------------------------------------
// GET operation
// -------------------------------------
public int get(int key) {

    // Key not present
    if (!map.containsKey(key))
        return -1;

    // Fetch node
    ListNode node = map.get(key);

    // Move node to MRU position
    deleteNode(node);
    addNode(node);

    return node.val;
}

// -------------------------------------
// PUT operation
// -------------------------------------
public void put(int key, int value) {

    // If key exists
    if (map.containsKey(key)) {

        ListNode node = map.get(key);

        // Update value
        node.val = value;

        // Move to MRU
        deleteNode(node);
        addNode(node);

        return;
    }

    // If cache is full
    if (map.size() == capacity) {

        // LRU node is just before tail
        ListNode lru = tail.prev;

        deleteNode(lru);

        // Remove from map
        map.remove(lru.key);
    }

    // Insert new node
    ListNode newNode =
        new ListNode(key, value);

    addNode(newNode);
    map.put(key, newNode);
}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */