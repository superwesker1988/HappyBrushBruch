import java.util.Arrays;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return new int[0];
        }
        int[] sortedNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedNums);
        int left = 0;
        int right = 0;
        int mid = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            }
            else if (sum < target) {
                left++;
            } else {
                int newLeft = 0;
                int newRight = 0;
                for (int index = 0; index < nums.length; index++) {
                    if (nums[left] == nums[index]) {
                        newLeft = index;
                    }
                    if (nums[right] == nums[idnex]) {
                        newRight = index;
                    }
                }
                return new int[]{newLeft, newRight};
            }
        }
        return new int[0];
    }
}