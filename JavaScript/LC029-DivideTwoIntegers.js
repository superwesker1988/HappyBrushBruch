/**
 * 
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 2^31 − 1 when the division result overflows.
 */

/**
 * @param {number} dividend
 * @param {number} divisor
 * @return {number}
 */
var divide = function(dividend, divisor) {
    const MAX_INT = Math.pow(2, 31) - 1,
    MIN_INT = -Math.pow(2, 31),
    isPositive = (dividend > 0) !== (divisor < 0);
    let result = 0,
    absDividend = Math.abs(dividend),
    absDivisor = Math.abs(divisor);
    
    if (absDividend < absDivisor) {
        return 0;
    }
    

    while (absDividend >= absDivisor) {
        let aggDivisor = absDivisor,
        shiftCnt = 0;
        while (absDividend >= aggDivisor << 1) {
            if ((aggDivisor << 1) <= 0) {
                break;
            }
            aggDivisor = aggDivisor << 1;
            shiftCnt++;
            if (isPositive && shiftCnt > 29) {
                return MAX_INT;
            }
            if (!isPositive && shiftCnt > 30) {
                return MIN_INT;
            }
        }
        absDividend -= aggDivisor;
        result += (1 << shiftCnt);
    }
    return isPositive ? result : - result;
};