/**
 * Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    if (!s || s.length === 0) {
        return 0;
    }
    let startIndex = 0;
    let maxLength = 0;
    let answerStart = 0;
    let answerEnd = 0;
    const charHash = Array(256).fill(0);
    for (let endIndex = 0; endIndex < s.length; endIndex++) {
        charHash[s.charCodeAt(endIndex)]++;
        while (charHash[s.charCodeAt(endIndex)] > 1) {
            charHash[s.charCodeAt(startIndex)]--;
            startIndex++;
        }
        if (maxLength < endIndex - startIndex + 1) {
            maxLength = endIndex - startIndex + 1;
            answerStart = startIndex;
            answerEnd = endIndex;
        }
    }
    // This will give you target substring if it is needed as return value.
    console.log(`${s.substring(answerStart, answerEnd + 1)}`);
    return maxLength;
};