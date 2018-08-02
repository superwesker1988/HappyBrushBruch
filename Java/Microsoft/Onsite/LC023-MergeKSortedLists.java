/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
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
    private ListNode mergeList(ListNode left, ListNode right) {
        ListNode dummyHead = new ListNode(1024);
        ListNode dummyPointer = dummyHead;
        while (left != null && right != null) {
            if (left.val < right.val) {
                dummyPointer.next = left;
                left = left.next;
            }
            else {
                dummyPointer.next = right;
                right = right.next;
            }
            dummyPointer = dummyPointer.next;
        }
        while (left != null) {
            dummyPointer.next = left;
            left = left.next;
            dummyPointer = dummyPointer.next;
        }
        while (right != null) {
            dummyPointer.next = right;
            right = right.next;
            dummyPointer = dummyPointer.next;
        }
        return dummyHead.next;
    }

    private ListNode mergeListsByIndex(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        if (left + 1 == right) {
            return mergeList(lists[left], lists[right]);
        }
        int mid = left + (right - left) / 2;
        ListNode leftList = mergeListsByIndex(lists, left, mid);
        ListNode rightList = mergeListsByIndex(lists, mid + 1, right);
        return mergeListsByIndex(lists, leftList, rightList);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeListsByIndex(lists, 0, lists.length - 1);
    }
}