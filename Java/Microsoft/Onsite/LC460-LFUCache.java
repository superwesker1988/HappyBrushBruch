import java.util.HashMap;
/**
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LFUCache cache = new LFUCache( 2 - capacity );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.get(3);       // returns 3.
cache.put(4, 4);    // evicts key 1.
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 * 
 */

class LFUCache {
    class DoublyLinkedList {
        public int value;
        public int key;
        public int freqency;
        public DoublyLinkedList prev;
        public DoublyLinkedList next;
        public DoublyLinkedList(int key, int value) {
            this.key = key;
            this.value = value;
            this.freqency = 1;
        }
        public DoublyLinkedList(int key, int value, int freqency) {
            this.key = key;
            this.value = value;
            this.freqency = freqency;
        }
    }

    private int capacity;
    private DoublyLinkedList head;
    private DoublyLinkedList tail;
    Map<Integer, DoublyLinkedList> storage;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.head = new DoublyLinkedList(-1, -1, 0);
        this.tail = new DoublyLinkedList(-1, -1, 0);
        this.storage = new HashMap<Integer, DoublyLinkedList>();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    private void insert(DoublyLinkedList node) {
        DoublyLinkedList pointer = this.head.next;
        while (pointer != this.tail && pointer.freqency <= node.freqency) {
            pointer = pointer.next;
        }
        pointer.prev.next = node;
        node.prev = pointer.prev;
        node.next = pointer;
        pointer.prev = node;
    }

    public int get(int key) {
        if (!this.storage.containsKey(key)) {
            return -1;
        }
        DoublyLinkedList targetNode = this.storage.get(key);
        targetNode.freqency++;
        targetNode.prev.next = targetNode.next;
        targetNode.next.prev = targetNode.prev;
        insert(targetNode);
        return targetNode.value;
    }
    
    public void put(int key, int value) {
        if (get(key) != -1) {
            this.storage.get(key).value = value;
            return;
        }
        // Removes head node if capacity is hit
        if (this.storage.size() == this.capacity) {
            this.storage.remove(this.head.next.key);
            this.head.next = this.head.next.next;
            this.head.next.prev = this.head;
        }
        DoublyLinkedList newNode = new DoublyLinkedList(key, value);
        insert(newNode);
        this.storage.put(key, newNode);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */