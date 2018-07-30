import java.util.HashMap;

import com.sun.jmx.remote.internal.ArrayQueue;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity  );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 */

public class LRUCache {
    public class DoublyLinkedList<T, U> {
        public T key;
        public U val;
        public DoublyLinkedList<T, U> prev;
        public DoublyLinkedList<T, U> next;
        public DoublyLinkedList(T key, U val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
        public DoublyLinkedList(T key, U val, DoublyLinkedList<T, U> prev) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = null;
        }
    }

    private int capacity;
    private Map<Integer, DoublyLinkedList> storage;
    private DoublyLinkedList<Integer, Integer> linkedListHead;
    private DoublyLinkedList<Integer, Integer> linkedListTail;

    private void moveNodeToTail(DoublyLinkedList<Integer, Integer> node) {
        node.prev = this.linkedListTail.prev;
        this.linkedListTail.prev = node;
        node.prev.next = node;
        node.next = this.linkedListTail;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.storage = new HashMap<Integer, DoublyLinkedList>();
        this.linkedListHead = new DoublyLinkedList<Integer, Integer>(-1, -1);
        this.linkedListTail = new DoublyLinkedList<Integer, Integer>(-1, -1);
        this.linkedListHead.next = this.linkedListTail;
        this.linkedListTail.prev = this.linkedListHead;
    }
    
    public int get(int key) {
        if (!this.storage.containsKey(key)) {
            return -1;
        }
        DoublyLinkedList<Integer, Integer> curNode = this.storage.get(key);
        curNode.prev.next = curNode.next;
        curNode.next.prev = curNode.prev;
        moveNodeToTail(curNode);
        return curNode.val;
    }   
    
    public void put(int key, int value) {
        // When the key is cached already, other its position in list
        if (get(key) != -1) {
            this.storage.get(key).val = value;
            return;
        }
        if (this.storage.size() == this.capacity) {
            this.storage.remove(this.linkedListHead.next.key);
            this.linkedListHead.next = this.linkedListHead.next.next;
            this.linkedListHead.next.prev = this.linkedListHead;
        }
        DoublyLinkedList<Integer, Integer> curNode = new DoublyLinkedList<Integer, Integer>(key, value);
        this.storage.put(key, curNode);
        moveNodeToTail(curNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */