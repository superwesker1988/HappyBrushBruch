/**
 * 
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
             because they are adjacent houses.
Example 2:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
 */

class Solution {
    private int getMaxIncome(int[] nums, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return nums[startIndex];
        }
        if (startIndex + 1 == endIndex) {
            return Math.max(nums[startIndex], nums[endIndex]);
        }
        int[] incomes = new int[2];
        incomes[startIndex % 2] = nums[startIndex];
        incomes[startIndex % 2 + 1] = Math.max(nums[startIndex], nums[endIndex]);
        for (int index = startIndex + 2; index <= endIndex; index++) {
            incomes[index % 2] = Math.max(incomes[(index - 1) % 2], incomes[(index - 2) % 2] + nums[index]);
        }
        return incomes[endIndex % 2];
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return Math.max(getMaxIncome(nums, 0, nums.length - 2), getMaxIncome(nums, 1, nums.length - 1));
    }
}