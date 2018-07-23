/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(1024);
        ListNode dummyPointer = dummyHead;
        ListNode l1Pointer = l1;
        ListNode l2Pointer = l2;
        int carry = 0;
        int sum = 0;
        while (l1Pointer != l2Pointer) {
            sum = carry;
            if (l1Pointer != null) {
                sum += l1Pointer.val;
                l1Pointer = l1Pointer.next;
            }
            if (l2Pointer != null) {
                sum += l2Pointer.val;
                l2Pointer = l2Pointer.next;
            }
            carry = sum > 9 ? 1 : 0;
            dummyPointer.next = new ListNode(sum % 10);
            dummyPointer = dummyPointer.next;
        }
        if (carry > 0) {
            dummyPointer.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}