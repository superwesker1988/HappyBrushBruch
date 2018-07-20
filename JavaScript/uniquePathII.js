/**
 * @param {number[][]} obstacleGrid
 * @return {number}
 */
var uniquePathsWithObstacles = function(obstacleGrid) {
    if (obstacleGrid === null || obstacleGrid.length === 0)
        return 0;
    const checkBoxes = [], m = obstacleGrid.length, n = obstacleGrid[0].length;
    let isBlocked = false;
    for (let i = 0; i < m; i++) {
        checkBoxes.push(Array(n).fill(0));
        if (obstacleGrid[i][0] === 1) {
            checkBoxes[i][0] = 0;
            isBlocked = true;
        }
        if (!isBlocked) {
            checkBoxes[i][0] = 1;
        } else {
            checkBoxes[i][0] = 0;
        }
    }
    isBlocked = false;
    for (let i = 0; i < n; i++) {
        if (obstacleGrid[0][i] === 1) {
            checkBoxes[0][i] = 0;
            isBlocked = true;
        } else if (!isBlocked) {
            checkBoxes[0][i] = 1;
        } else {
            checkBoxes[0][i] = 0;
        }
    }
    for (let i = 1; i < m; i++) {
        for (let j = 1; j < n; j++) {
            if (obstacleGrid[i][j] === 1) {
                checkBoxes[i][j] = 0;
            } else {
                checkBoxes[i][j] = checkBoxes[i - 1][j] + checkBoxes[i][j - 1];
            }
        }
    }
    return checkBoxes[m - 1][n - 1];
};