/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its subarray.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: [4,-1,2,1]
Explanation: [4,-1,2,1] has the largest sum = 6.
 */

class Solution {
    public int[] maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        
        int sum = 0, max = Integer.MIN_VALUE, left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
                left = i;
            }
            sum += nums[i];
            if (max < sum) {
                max = sum;
                right = i;
            }
        }
        int[] answer = new int[right - left + 1];
        for (int i = left; i <= right; i++) {
            answer[i - left] = nums[i];
        }
        return answer;
    }
}