/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalRectangle = function(matrix) {
    if (matrix === null || matrix.length === 0)
        return 0;
    let maxArea = 0;
    const newMatrix = Array(matrix.length);
    for (let i = 0; i < matrix.length; i++) {
        newMatrix[i] = Array(matrix[i].length).fill(0);
        for (let j = 0; j < newMatrix[i].length; j++) {
            if (matrix[i][j] === "0") {
                newMatrix[i][j] = 0;
            } else {
                newMatrix[i][j] = (i === 0 ? 0 : newMatrix[i - 1][j]) + 1;
            }
        }
        console.log(`${newMatrix[i]}`);
    }
    for (let i = 0; i < newMatrix.length; i++) {
        maxArea = Math.max(maxArea, largestRectangleArea(newMatrix[i]));
    }
    return maxArea;
};

/**
 * @param {number[]} heights
 * @return {number}
 */
var largestRectangleArea = function(heights) {
    if (heights === null || heights.length === 0)
        return 0;
    const heightStack = [];
    let maxArea = 0;
    for (let i = 0; i <= heights.length; i++) {
        let newHeight = (i === heights.length) ? -1 : heights[i];
        while (heightStack.length > 0 && newHeight <= heights[heightStack[heightStack.length - 1]]) {
            let curHeight = heights[heightStack.pop()];
            let curWidth = heightStack.length === 0 ? i : i - heightStack[heightStack.length - 1] - 1;
            maxArea = Math.max(maxArea, curHeight * curWidth);
        }
        heightStack.push(i);
    }
    return maxArea;
};

maximalRectangle([["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]])
