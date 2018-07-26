/**
 * Given an input string , reverse the string word by word. 

Example:

Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Note: 

A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.
Follow up: Could you do it in-place without allocating extra space?
 */

class Solution {
    private void reverseWord(char[] str, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            swapChar(str, startIndex, endIndex);
            startIndex++;
            endIndex--;
        }
    }

    private void swapChar(char[] str, int left, int right) {
        char temp = str[left];
        str[left] = str[right];
        str[right] = temp;
    } 

    public void reverseWords(char[] str) {
        if (str == null || str.length == 0) {
            return;
        }
        int start = 0;
        for (int index = 0; index < str.length; index++) {
            if (str[index] != ' ') {
                continue;
            } else {
                reverseWord(str, start, index - 1);
                start = index + 1;
            }
        }
        reverseWord(str, start, str.length - 1);
        start = 0;
        int end = str.length - 1;
        while (start < end) {
            swapChar(str, start, end);
            start++;
            end--;
        }
    }
}