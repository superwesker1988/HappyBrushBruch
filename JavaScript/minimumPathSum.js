/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function(grid) {
    if (grid === null || grid.length === 0)
        return 0;
    const checkBoxes = [], m = grid.length, n = grid[0].length;
    for (let i = 0; i < m; i++) {
        checkBoxes.push(Array(n).fill(0));
        checkBoxes[i][0] = i === 0 ? grid[i][0] : grid[i][0] + checkBoxes[i - 1][0];
    }
    for (let i = 1; i < n; i++) {
        checkBoxes[0][i] = checkBoxes[0][i - 1] + grid[0][i]
    }
    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) {
            checkBoxes[i][j] = Math.min(checkBoxes[i][j - 1], checkBoxes[i - 1][j]) + grid[i][j];
        }
    }
    return checkBoxes[m - 1][n - 1];
};
