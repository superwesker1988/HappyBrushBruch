import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for (int index = 0; index < nums.length - 2; index++) {
            if (index > 0 && nums[index] == nums[index - 1]) {
                continue;
            }
            populate2Sum(nums, nums[index], 0 - nums[index], index + 1, answer);
        }
        return answer;
    }

    private void populate2Sum(int[] nums, int firstNum, int target, int startIndex, List<List<Integer>> answer) {
        int left = startIndex, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                Integer[] curCombo = new Integer[]{firstNum, nums[left], nums[right]};
                answer.add(new ArrayList<Integer>(Arrays.asList(curCombo)));
                left++;
                right--;
                while (left < nums.length && nums[left] == nums[left - 1]) {
                    left++;
                }
                while (right >= 0 && nums[right] == nums[right + 1]) {
                    right--;
                }
            }
        }
        return;
    }
}