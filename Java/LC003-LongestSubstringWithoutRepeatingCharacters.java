import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;
        int[] charAscIIMap = new int[256];
        int endIndex = 0;
        int answer = 0;
        for (int index = 0; index < s.length(); index++) {
            while (endIndex < s.length() && charAscIIMap[s.charAt(endIndex)] == 0) {
                charAscIIMap[s.charAt(endIndex)] = 1;
                answer = Math.max(answer, endIndex - index + 1);
                endIndex++;
            }
            charAscIIMap[s.charAt(index)] = 0;
        }
        return answer;
    }
}