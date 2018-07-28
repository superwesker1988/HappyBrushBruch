/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
 */
class Solution {
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private void rainbowSort(int[] nums, int left, int right, int startColor, int endColor) {
        if (left >= right) {
            return;
        }
        if (startColor == endColor) {
            return;
        }
        int newLeft = left, newRight = right;
        int midColor = startColor + (endColor - startColor) / 2;
        while (newLeft <= newRight) {
            while (newLeft <= newRight && nums[newLeft] <= midColor) {
                newLeft++;
            }
            while (newLeft <= newRight && nums[newRight] > midColor) {
                newRight--;
            }
            if (newLeft < newRight) {
                swap(nums, newLeft, newRight);
                newLeft++;
                newRight--;
            }
        }
        rainbowSort(nums, left, newRight, startColor, midColor);
        rainbowSort(nums, newLeft, right, midColor + 1, endColor);
    }
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        rainbowSort(nums, 0, nums.length - 1, 1, 3);
    }
}