import java.util.Deque;

/**
 * 
 */

class Solution {
    private void pushQueue(Deque<Integer> deque, int num) {
        while (!deque.isEmpty() && num < deque.peekLast()) {
            deque.pollLast();
        }
        deque.offer(num);
    }

    private void popQueue(Deque<Integer> deque, int num) {
        if (!deque.isEmpty() && num == deque.peekFirst()) {
            deque.pollFirst();
        }
    }

    public int[] SlidingWindowMinimum(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new ArrayQueue<>();
        int[] answer = new int[nums.length - k + 1];
        for (int index = 0; index < k - 1; index++) {
            pushQueue(deque, nums[index]);
        }
        for (int index = k - 1; index < nums.length; index++) {
            int curNum = nums[index];
            pushQueue(deque, curNum);
            answer[index - k + 1] = deque.peekFirst();
            popQueue(deque, nums[index - k + 1]);
        }
        return answer;
    }
}