/*
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
*/

/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    let carry = 0;
    const answer = [];
    for (let i = 0; i < digits.length; i++) {
        let newDigit = digits[digits.length - 1 - i] + carry + (i === 0 ? 1 : 0);
        answer.unshift((newDigit) % 10);
        carry = Math.floor(newDigit / 10);
    }
    if (carry > 0)
        answer.unshift(1);
    return answer;
};