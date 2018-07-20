/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping way:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Beyond that, now the encoded string can also contain the character '*', which can be treated as one of the numbers from 1 to 9.

Given the encoded message containing digits and the character '*', return the total number of ways to decode it.

Also, since the answer may be very large, you should return the output mod 109 + 7.

Example 1:
Input: "*"
Output: 9
Explanation: The encoded message can be decoded to the string: "A", "B", "C", "D", "E", "F", "G", "H", "I".
Example 2:
Input: "1*"
Output: 9 + 9 = 18
Note:
The length of the input string will fit in range [1, 105].
The input string will only contain the character '*' and digits '0' - '9'.
 */

/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function(s) {
    if (s === null || s.length === 0) {
        return 0;
    }
    const answer = Array(s.length + 1).fill(0), MOD_VALUE = 1000000000 + 7;
    answer[0] = 1;
    for (let i = 1; i < s.length + 1; i++) {
        answer[i] = answer[i - 1] * getLastCharMultiplier(s[i - 1]);
        if (i > 1) {
            answer[i] += answer[i - 2] * getLast2CharMultiplier(s.substring(i - 2, i));
        }
        answer[i] = answer[i] % MOD_VALUE;
    }
    return answer[s.length];
};

var getLast2CharMultiplier = function(str) {
    const char1 = str[0], char2 = str[1];
    if (char1 === "0") {
        return 0;
    }
    if (char1 === "1") {
        if (char2 === "*")
            return 9;
        return 1;
    }
    if (char1 === "2") {
        if (char2 === "*")
            return 6;
        return Number.parseInt(char2) >= 0 && Number.parseInt(char2) <= 6 ? 1 : 0;
    }
    if (char1 >= "3" && char1 <= "9") {
        return 0;
    }
    // Now handle str[0] === "*"
    if (char2 >= "0" && char2 <= "6") {
        return 2;
    } 
    if (char2 >= "7" && char2 <= "9") {
        return 1;
    }
    return 15;
};

var getLastCharMultiplier = function(char) {
    switch (char) {
        case "0":
            return 0;
        case "*":
            return 9;
        default:
            return 1;
    }
};

