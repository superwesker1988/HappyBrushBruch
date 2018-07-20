/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?


 */

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
        if (head == null)
            return null;
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        boolean isSearchStarted = false;
        while (!isSearchStarted || fastPointer != slowPointer) {
            isSearchStarted = true;
            if (fastPointer == null || fastPointer.next == null) {
                return null;
            }
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        ListNode answerPointer = head;
        while (answerPointer != slowPointer) {
            answerPointer = answerPointer.next;
            slowPointer = slowPointer.next;
        }
        return answerPointer;
    }
}