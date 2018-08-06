/**
 * 
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
 */

class Solution {
    
    
    public boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        char[] pattern = p.toCharArray();
        char[] source = s.toCharArray();
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        // Assume "" matches ""
        dp[0][0] = true;
        for (int i = 2; i < pLength + 1; i++) {
            if (pattern[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        
        for (int sInd = 1; sInd < sLength + 1; sInd++) {
            for (int pInd = 1; pInd < pLength + 1; pInd++) {
                if (pattern[pInd - 1] == '.' || pattern[pInd - 1] == source[sInd - 1]) {
                    dp[sInd][pInd] = dp[sInd - 1][pInd - 1];
                }
                else if (pattern[pInd - 1] == '*' && pInd >= 2) {
                    dp[sInd][pInd] = dp[sInd][pInd - 2];
                    if (pattern[pInd - 2] == '.' || pattern[pInd - 2] == source[sInd - 1]) {
                        dp[sInd][pInd] |= dp[sInd - 1][pInd];
                    }
                }
                else {
                    dp[sInd][pInd] = false;
                }
            }
        }
        return dp[sLength][pLength];
    }
}