import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

Example:

Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
Output: [3,3,5,5,6,7] 
Explanation: 

Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Note: 
You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 */

class Solution {
    /**
     * Making sure deque is stored in descending order
     */
    private void pushQueue(Deque<Integer> deque, int num) {
        while (!deque.isEmpty() && num > deque.peekLast()) {
            deque.pollLast();
        }
        deque.offer(num);
    }
    /**
     * Pop previous max if num == pre max (meaning pre max no longer in window)
     */
    private void popQueue(Deque<Integer> deque, int num) {
        if (deque.peekFirst() == num) {
            deque.pollFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] answer = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int index = 0; index < k - 1; index++) {
            pushQueue(deque, nums[index]);
        }
        for (int index = k - 1; index < nums.length; index++) {
            // Add new num to deque
            pushQueue(deque, nums[index]);
            // The head of deque is max number in window
            answer[index - k + 1] = deque.peekFirst();
            // Remove max number if it is not in the window anymore
            popQueue(deque, nums[index - k + 1]);
        }
        return answer;
    }
}