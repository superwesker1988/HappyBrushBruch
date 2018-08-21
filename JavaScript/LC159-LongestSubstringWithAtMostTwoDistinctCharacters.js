/**
 * Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
 */

/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstringTwoDistinct = function(s) {
    let answer = 0;
    let startIndex = 0;
    const picked = new Map();
    for (let endIndex = 0; endIndex < s.length; endIndex++) {
        add(picked, s[endIndex]);
        while (picked.size > 2) {
            remove(picked, s[startIndex]);
            startIndex++;
        }
        answer = Math.max(answer, endIndex - startIndex + 1);
    }
    return answer;
};

const add = function(map, target) {
    if (map.has(target)) {
        map.set(target, map.get(target) + 1);
    } else {
        map.set(target, 1);
    }
};

const remove = function(map, target) {
    if (map.get(target) === 1) {
        map.delete(target);
    } else {
        map.set(target, map.get(target) - 1);
    }
};