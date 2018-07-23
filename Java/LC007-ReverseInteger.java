/**
 * Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */

class Solution {
    public int reverse(int x) {
        if (x == 0)
            return 0;
        int sign = x > 0 ? 1 : -1;
        x = Math.abs(x);
        int answer = 0;
        while (x) {
            int newInteger = answer * 10 + (x % 10);
            if (newInteger / 10 != answer) {
                return 0;
            }
            answer = newInteger;
            x /= 10;
        }
        answer *= sign;
        return answer;
    }
}