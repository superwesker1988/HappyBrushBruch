/**
 * @param {string} s
 * @return {number}
 */
var numDecodings = function(s) {
    if (s === null || s.length === 0)
        return 0;
    const answer = Array(s.length + 1).fill(0);
    answer[0] = 1;
    answer[1] = s[0] === "0" ? 0 : 1;
    for (let i = 2; i < s.length + 1; i++) {
        if (s[i - 1] !== "0") {
            answer[i] = answer[i - 1];
        }
        let curValue = Number.parseFloat(s.substring(i - 2, i1));
        if (curValue >= 10 && curValue <= 26) {
            answer[i] += answer[i - 2];
        }
    }
    return answer[s.length];
};

