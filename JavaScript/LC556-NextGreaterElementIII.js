/**
 * 
Given a positive 32-bit integer n, you need to find the smallest 32-bit integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive 32-bit integer exists, you need to return -1.

Example 1:

Input: 12
Output: 21
 

Example 2:

Input: 21
Output: -1
 
 */

const swap = (array, leftInd, rightInd) => {
    const temp = array[leftInd];
    array[leftInd] = array[rightInd];
    array[rightInd] = temp;
};
/**
 * @param {number} n
 * @return {number}
 */
var nextGreaterElement = function(n) {
    const numStr = n + "";
    if (numStr.length < 2) {
        return -1;
    }
    let swapLeft = -1;
    const digits = numStr.map(str => Number.parseInt(str));
    for (let ind = digits.length - 1; ind > 0; ind--) {
        if (digits[ind] > digits[ind - 1]) {
            swapLeft = ind - 1;
        }
    }
    if (swapLeft < 0) {
        return -1;
    }
    for (let ind = digits.length - 1; ind >= swapLeft; ind--) {
        if (digits[ind] > digits[swapLeft]) {
            swap(digits, swapLeft, ind);
            return Number.parseInt(digits.slice(0, swapLeft).concat(digits.slice(swapLeft + 1).sort((a, b) => {
                return a - b;
            })).join().replace(/,/g, ""));
        }
    }
    return -1;
};