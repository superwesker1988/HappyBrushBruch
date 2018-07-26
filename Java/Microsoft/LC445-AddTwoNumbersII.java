/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
 */

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    private ListNode getReverseList(ListNode ogList) {
        if (ogList == null)
            return null;
        ListNode dummyHead = new ListNode(1024);
        dummyHead.next = ogList;
        ListNode dummyPointer = dummyHead;
        ListNode pointer = ogList.next;
        ogList.next = null;
        while (pointer != null) {
            ListNode nextNode = pointer.next;
            ListNode preNode = dummyHead.next;
            pointer.next = preNode;
            dummyHead.next = pointer;
            pointer = nextNode;
        }
        return dummyHead.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return new ListNode(0);
        }
        ListNode answerListHead = new ListNode(1024);
        ListNode answerListPointer = answerListHead;
        ListNode reversedL1 = getReverseList(l1);
        ListNode reversedL2 = getReverseList(l2);
        int carry = 0;
        while (reversedL1 != null && reversedL2 != null) {
            int sum = carry + reversedL1.val + reversedL2.val;
            answerListPointer.next = new ListNode(sum % 10);
            answerListPointer = answerListPointer.next;
            carry = sum / 10;
            reversedL1 = reversedL1.next;
            reversedL2 = reversedL2.next;
        }
        while(reversedL1 != null) {
            int sum = carry + reversedL1.val;
            answerListPointer.next = new ListNode(sum % 10);
            answerListPointer = answerListPointer.next;
            carry = sum / 10;
            reversedL1 = reversedL1.next;
        }
        while(reversedL2 != null) {
            int sum = carry + reversedL2.val;
            answerListPointer.next = new ListNode(sum % 10);
            answerListPointer = answerListPointer.next;
            carry = sum / 10;
            reversedL2 = reversedL2.next;
        }
        if (carry > 0) {
            answerListPointer.next = new ListNode(carry);
        }
        return getReverseList(answerListHead.next);
    }
}