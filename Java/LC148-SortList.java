/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode getMergedList(ListNode leftList, ListNode rightList) {
        ListNode dummyHead = new ListNode(1024);
        ListNode dummyPointer = dummyHead;
        while (leftList != null && rightList != null) {
            if (leftList.val < rightList.val) {
                dummyPointer.next = leftList;
                leftList = leftList.next;
            } else {
                dummyPointer.next = rightList;
                rightList = rightList.next;
            }
            dummyPointer = dummyPointer.next;
        }
        while (leftList != null) {
            dummyPointer.next = leftList;
            leftList = leftList.next;
            dummyPointer = dummyPointer.next;
        }
        while (rightList != null) {
            dummyPointer.next = rightList;
            rightList = rightList.next;
            dummyPointer = dummyPointer.next;
        }
        return dummyHead.next;
    }

    private ListNode getMidNode(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fastPointer = head;
        ListNode slowPointer = head;
        while (fastPointer.next != null && fastPointer.next.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode midNode = getMidNode(head);
        ListNode rightHead = null;
        if (midNode != null) {
            rightHead = midNode.next;
            midNode.next = null;
        }
        ListNode leftList = sortList(head);
        ListNode rightList = sortList(rightHead);
        return getMergedList(leftList, rightList);
    }
}