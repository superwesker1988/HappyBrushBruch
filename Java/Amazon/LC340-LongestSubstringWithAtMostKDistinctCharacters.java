/**
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2,

T is "ece" which its length is 3.

 * 
 */


class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] charsOfS = s.toCharArray();
        int[] charHashCnt = new int[256];
        int left = 0;
        int distinctChars = 0;
        int answer = 0;
        for (int right = 0; right < charsOfS.length; right++) {
            charHashCnt[charsOfS[right]]++;
            if (charHashCnt[charsOfS[right]] == 1) {
                distinctChars++;
            }
            // When we have enough distinct characters, we starts to narrow it down
            while (distinctChars > k) {
                charHashCnt[charsOfS[left]]--;
                if (charHashCnt[charsOfS[left]] == 0) {
                    distinctChars--;
                }
                left++;
            }
            answer = Math.max(answer, right - left + 1);
        }
        return answer;
    }
}