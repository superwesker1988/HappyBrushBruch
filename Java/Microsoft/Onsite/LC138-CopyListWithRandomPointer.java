/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
 */

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode pointer = head;
        RandomListNode dummyHead = new RandomListNode(1024);
        RandomListNode dummyPointer = dummyHead;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        while (pointer != null) {
            RandomListNode newNode = new RandomListNode(pointer.label);
            map.put(pointer, newNode);
            dummyPointer.next = newNode;
            dummyPointer = dummyPointer.next;
            pointer = pointer.next;
        }
        pointer = head;
        dummyPointer = dummyHead.next;
        while (pointer != null) {
            dummyPointer.random = map.get(pointer.random);
            dummyPointer = dummyPointer.next;
            pointer = pointer.next;
        }
        return dummyHead.next;
    }
}
//Solution 2, NO map
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    private void copyNext(RandomListNode head) {
        RandomListNode pointer = head;
        while (pointer != null) {
            RandomListNode copy = new RandomListNode(pointer.label);
            RandomListNode preNext = pointer.next;
            pointer.next = copy;
            copy.next = preNext;
            pointer = preNext;
        }
    }

    private void associateRandom(RandomListNode head) {
        RandomListNode pointer = head;
        while (pointer != null) {
            if (pointer.random != null) {
                pointer.next.random = pointer.random.next;
            }
            pointer = pointer.next.next;
        }
    }

    private RandomListNode getCopyHead(RandomListNode head) {
        RandomListNode copyHead = head.next;
        RandomListNode copyPointer = copyHead;
        RandomListNode pointer = head;
        while (pointer != null) {
            pointer.next = pointer.next.next;
            pointer = pointer.next;
            if (copyPointer.next != null) {
                copyPointer.next = copyPointer.next.next;
                copyPointer = copyPointer.next;
            }
        }
        return copyHead;
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        copyNext(head);
        associateRandom(head);
        return getCopyHead(head);
    }
}