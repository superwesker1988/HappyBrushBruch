/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    if (m === 0 || n === 0) {
        return 0;
    }
    const checkBoxes = [];
    for (let i = 0; i < m; i++) {
        checkBoxes.push(Array(n).fill(i === 0 ? 1 : 0));
        checkBoxes[i][0] = 1;
    }

    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) {
            checkBoxes[i][j] = checkBoxes[i - 1][j] + checkBoxes [i][j - 1];
        }
    }
    return checkBoxes[m - 1][n - 1];
};
