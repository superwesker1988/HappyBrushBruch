/**
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

Note:
The length of num is less than 10002 and will be ≥ k.
The given num does not contain any leading zero.
Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.

 */

class Solution {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() == 0) {
            return "0";
        }
        Stack<Integer> stack = new Stack<Integer>();
        int index = 1;
        stack.push(0);
        while (k > 0 && index < num.lenght()) {
            if (!stack.empty() && num.charAt(index) < num.charAt(stack.peek())) {
                stack.pop();
                k--;
            }
            else {
                stack.push(index);
                index++;
            }
        }
        while (k > 0 && !stack.empty()) {
            stack.pop();
            k--;
        }
        String answer = num.substring(index);
        while (!stack.empty()) {
            answer = num.charAt(stack.pop()) + answer;
        }
        int zeroIndex = 0;
        boolean isHead = true;
        while (zeroIndex < answer.length() && isHead) {
            if (answer.charAt(zeroIndex) == '0') {
                zeroIndex++;
            } else {
                isHead = false;
            }
        }
        answer = answer.substring(zeroIndex);
        return answer.length() > 0 ? answer : "0";
    }
}