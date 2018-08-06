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

class LRUCache {
	class DoublyLinkedList<T, U> {
		public DoublyLinkedList<T, U> next;
		public DoublyLinkedList<T, U> prev;
		public T key;
		public U value;
		public DoublyLinkedList(T key, U value) {
			this.key = key;
			this.value = value;
			next = null;
			prev = null;
		}
	}
	
	private DoublyLinkedList<Integer, Integer> head;
	private DoublyLinkedList<Integer, Integer> tail;
	private Map<Integer, DoublyLinkedList<Integer, Integer>> map;
	private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
		map = new HashMap<Integer, DoublyLinkedList<Integer, Integer>>();
		head = new DoublyLinkedList<Integer, Integer>(-1, -1);
		tail = new DoublyLinkedList<Integer, Integer>(-1, -1);
		head.next = tail;
		tail.prev = head;
    }
	
	private void moveNodeToTail(DoublyLinkedList<Integer, Integer> node) {
		DoublyLinkedList<Integer, Integer> prevTail = this.tail.prev;
		prevTail.next = node;
		node.prev = prevTail;
		node.next = this.tail;
		this.tail.prev = node;
	}
    
    public int get(int key) {
        if (!this.map.containsKey(key)) {
			return -1;
		}
		DoublyLinkedList<Integer, Integer> targetNode = map.get(key);
		targetNode.prev.next = targetNode.next;
		targetNode.next.prev = targetNode.prev;
		moveNodeToTail(targetNode);
		return targetNode.value;
    }
    
    public void put(int key, int value) {
        if (this.get(key) != -1) {
			map.get(key).value = value;
            return;
		}
		if (this.capacity == this.map.size()) {
			this.map.remove(this.head.next.key);
			this.head.next = this.head.next.next;
			this.head.next.prev = this.head;
		}
		DoublyLinkedList<Integer, Integer> newNode = new DoublyLinkedList<Integer, Integer>(key, value);
		this.map.put(key, newNode);
        moveNodeToTail(newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */