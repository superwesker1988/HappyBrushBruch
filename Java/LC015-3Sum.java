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
        List<Integer> curCombo = new ArrayList<Integer>();
        populate2Sum(nums, 0 - nums[index], index + 1, curCombo);
        if (curCombo.size() == 2) {
          curCombo.add(nums[index]);
          answer.add(curCombo);
        }
      }
      return answer;
  }

  private void populate2Sum(int[] nums, int target, int startIndex, List<Integer> answer) {
    int left = startIndex, right = nums.length - 1;
    while (left < right) {
      int sum = nums[left] + nums[right];
      if (sum > target) {
        right--;
      }
      else if (sum < target) {
        left++;
      }
      else {
        answer.add(nums[left]);
        answer.add(nums[right]);
        left++;
        right--;
      }
    }
    return;
  }
}