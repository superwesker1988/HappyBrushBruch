import java.util.Map;

/**
 * 
You are given an integer array sorted in ascending order (may contain duplicates), you need to split them into several subsequences, where each subsequences consist of at least 3 consecutive integers. Return whether you can make such a split.

Example 1:
Input: [1,2,3,3,4,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3
3, 4, 5
Example 2:
Input: [1,2,3,3,4,4,5,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3, 4, 5
3, 4, 5
Example 3:
Input: [1,2,3,4,4,5]
Output: False
Note:
The length of the input is in range of [1, 10000]
 */

// The basic idea is to identify number of lists which has only 1-char or 2-chars at the end of execution.
public class Solution {
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int offSet = -nums[0];
        int[] freqMap = new int[10000];
        for (int index = 0; index < nums.length; index++) {
            freqMap[offSet + nums[index]]++;
        }
        // Variable to keep track of the number of lists which has only 1 char, 2 char, and more than 3 char.
        int numOfOneCharList = 0, numOfTwoCharList = 0, numOfThreeCharList = 0;
        int preNumber = nums[0];
        for (int index = -offSet; index <= nums[nums.length - 1]; index++) {
            int curCount = freqMap[index + offSet];
            // When current number count is less than total of once arrays and twice arrays
            // Or number is not consectutive after we have started a consectutive sequence, we return false.
            if (numOfOneCharList + numOfTwoCharList > curCount ||
            (numOfOneCharList + numOfTwoCharList != 0 && preNumber + 1 != index)) {
                return false;
            }
            // There is a break of consecutive here, which means current char does not belong to previous lists.
            if (preNumber + 1 != index) {
                numOfThreeCharList = 0;
            }
            // Feed both 1-char and 2-char list with current count
            int remainingCount = curCount - numOfOneCharList - numOfTwoCharList;
            numOfThreeCharList = Math.min(numOfThreeCharList, remainingCount);
            // Feed more-than-3-char lists 
            remainingCount -= numOfThreeCharList;
            // 2-char list becomes more-than-3-char lists
            numOfThreeCharList += numOfTwoCharList;
            // 1-char list becomes 2-char list
            numOfTwoCharList = numOfOneCharList;
            // The remaining count becomes new 1-char list
            numOfOneCharList = remainingCount;
            preNumber = index;
            
        }
        // If no list contains only 1 or 2 char, then it would be true
        return numOfOneCharList + numOfTwoCharList == 0;
    }
}