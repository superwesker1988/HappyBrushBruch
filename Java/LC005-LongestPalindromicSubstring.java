/**
 * 
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 */

class Solution {
    public String longestPalindrome(String s) {
        StringBuffer formattedStrBuffer = new StringBuffer();
        for (int index = 0; index < s.length(); index++) {
            formattedStrBuffer.append('#');
            formattedStrBuffer.append(s.charAt(index));
        }
        formattedStrBuffer.append('#');
        String newString = formattedStrBuffer.toString();
        int[] answerArray = new int[newString.length()];
        int midIndex = 0;
        int longestLength = 1;
        answerArray[0] = 1;
        for (int index = 1; index < newString.length(); index++) {
            int length = 1;
            if (midIndex + longestLength > index) {
                // Take 
                length = Math.min(answerArray[2 * midIndex - index], midIndex + longestLength - index);
            }
            while (index + length < newString.length() && index - length >= 0) {
                if (newString.charAt(index - length) != newString.charAt(index + length)) {
                    break;
                }
                length++;
            }
            if (length > longestLength) {
                longestLength = length;
                midIndex = index;
            }
            answerArray[index] = length;
        }
        int startIndex = (midIndex - 1) / 2 - (longestLength - 2) / 2;
        return s.substring(startIndex, startIndex + longestLength - 1);
    }
}