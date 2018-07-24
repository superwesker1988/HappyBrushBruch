import java.util.Arrays;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */

class Solution {
    private int[] getMapArray(String str) {
        int[] mapArray = new int[256];
        for (char curChar : str.toCharArray()) {
            if (mapArray[curChar] < 0) {
                mapArray[curChar] = 1;
            } else {
                mapArray[curChar]++;
            }
        }
        return mapArray;
    }
    public String minWindow(String s, String t) {
        int[] targetMap = getMapArray(t);
        int minLength = Integer.MAX_VALUE, startIndex = 0, sourceCnt = 0, targetCnt = t.length();
        String minSubstring = "";
        for (int endIndex = 0; endIndex < s.length(); endIndex++) {
            char tailChar = s.charAt(endIndex);
            // Matches target
            if (targetMap[tailChar] > 0) {
                sourceCnt++;
            }
            // Reduces count of target map, would be minus if char is not in target string
            targetMap[tailChar]--;
            // When a valid substring is found
            while (sourceCnt >= targetCnt) {
                char headChar = s.charAt(startIndex);
                // A better candidate is found, in this case, a shorter substring
                if (minLength > endIndex - startIndex + 1) {
                    minLength = endIndex - startIndex + 1;
                    minSubstring = s.substring(startIndex, endIndex + 1);
                }
                // Increase count of target map, it won't be > 0 if it is not in target
                targetMap[headChar]++;
                // Reduce source count only if the head char is in target string
                if (targetMap[headChar] > 0) {
                    sourceCnt--;
                }
                // Move head towards tail at 1 step
                startIndex++;
            }
        }
        return minSubstring;
    }
}