class MyHashMap {
    private static final int DEFAULT_CAPACITY = 16;
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    static class Node {
        final int hash;
        final int key;
        int value;
        Node next;

        Node(int hash, int key, int value, Node next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node[] table;
    private int size; 
    private float loadFactor;
    private int threshold;

    public MyHashMap() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int initialCapacity, float loadFactor) {
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);
    }

    public static int tableSizeFor(int cap) {
        int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
    
    public Integer put(int key, int value) {
        return putVal(hash(key), key, value);
    }

    public Integer putVal(int hash, int key, int value) {
        if (table == null || table.length == 0) {
            table = new Node[threshold];
        }
        int n = table.length;
        int i = (n - 1) & hash;

        for (Node node = table[i]; node != null; node = node.next) {
            if (node.hash == hash && node.key == key) {
                int oldValue = node.value;
                node.value = value;
                return oldValue;
            }
        }

        table[i] = new Node(hash, key, value, table[i]);
        size++;
        return null;
    }
    
    public Integer get(int key) {
        Node node = getNode(hash(key), key);
        return node == null ? -1 : node.value;
    }
    
    private Node getNode(int hash, int key) {
        if (table == null || table.length == 0) return null;
        int n = table.length;
        Node node = table[(n - 1) & hash];

        while (node != null) {
            if (node.hash == hash && node.key == key) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public Integer remove(int key) {
        int hash = hash(key);
        if (table == null || table.length == 0) return null;
        int n = table.length;
        int i = (n - 1) & hash;
        Node prev = null;
        Node current = table[i];

        while (current != null) {
            if (current.hash == hash && current.key == key) {
                if (prev == null) {
                    table[i] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */