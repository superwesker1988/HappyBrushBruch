/**
 * 
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

Example 1:

Input: [3,2,3]
Output: [3]
Example 2:

Input: [1,1,1,3,3,2,2,2]
Output: [1,2]
 */

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> answer = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return answer;
        }
        // There will be at most 2 numbers qulify the case
        // Create 2 variable set to track such numbers
        int num1 = 0, num2 = 0, num1Cnt = 0, num2Cnt = 0;
        // Scan through the array to find candidates
        for (int num : nums) {
            if (num == num1) {
                num1Cnt++;
            }
            else if (num == num2) {
                num2Cnt++;
            }
            else if (num1Cnt == 0) {
                num1 = num;
                num1Cnt++;
            }
            else if (num2Cnt == 0) {
                num2 = num;
                num2Cnt++;
            }
            else {
                num2Cnt--;
                num1Cnt--;
            }
        }
        // Reset Counter
        num1Cnt = num2Cnt = 0;
        // Collect counts of candidates
        for (int num : nums) {
            if (num == num1) {
                num1Cnt++;
            } else if (num == num2) {
                num2Cnt++;
            }
        }
        if (num1Cnt > nums.length / 3) {
            answer.add(num1);
        }
        if (num2Cnt > nums.length / 3) {
            answer.add(num2);
        }
        return answer;
    }
}