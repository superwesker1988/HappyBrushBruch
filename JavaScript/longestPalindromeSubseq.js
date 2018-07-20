/**
 * @param {string} s
 * @return {number}
 */
var longestPalindromeSubseq = function(s) {
    if (s === null)
        return 0;
    if (s.length < 2)
        return s.length;
    const dpArray = [];
    for (let i = 0; i < s.length; i++) {
        dpArray.push([]);
        for (let j = 0; i < s.length; j++) {
            if (i === j) {
                dpArray[i].push(1);
            } else {
                dpArray[i].push(0);
            }
        }
    }

    for (let i = s.length - 2; i > 0; i--) {
        for (let j = i + 1; j < s.length; j++) {
            
        }
    }
};