/**
 * 
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */

/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    if (n === 0) {
        return "";
    }
    const answer = [];
    dfsHelper(answer, "", n, n);
    return answer;
};

var dfsHelper = function(answer, curStr, leftP, rightP) {
    if (leftP === 0 && rightP === 0) {
        answer.push(curStr);
        return;
    }
    if (leftP > 0) {
        dfsHelper(answer, curStr + "(", leftP - 1, rightP);
    }
    if (rightP > 0 && leftP < rightP) {
        dfsHelper(answer, curStr + ")", leftP, rightP - 1);
    }
};
