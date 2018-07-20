/**
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */

class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        int[] max_product = Arrays.copyOf(nums, nums.length);
        int[] min_product = Arrays.copyOf(nums, nums.length);
        int answer = nums[0];
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] > 0) {
                max_product[index] = Math.max(nums[index], nums[index] * max_product[index - 1]);
                min_product[index] = Math.min(nums[index], nums[index] * min_product[index - 1]);
            } else {
                max_product[index] = Math.max(nums[index], nums[index] * min_product[index - 1]);
                min_product[index] = Math.min(nums[index], nums[index] * max_product[index - 1]);
            }
            answer = Math.max(answer, max_product[index]);
        }
        return answer;
    }
}