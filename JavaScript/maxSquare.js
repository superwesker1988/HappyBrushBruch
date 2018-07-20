/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalSquare = function(matrix) {
    if (matrix === null || matrix.length === 0)
        return 0;
    const N = matrix.length, M = matrix[0].length, resultBox = Array(N), longestEdge = 0;
    for (let i = 0; i < N; i++) {
        resultBox[i] = Array(M).fill(0);
        resultBox[i][0] = matrix[i][0] - "0";
        longestEdge = Math.max(longestEdge, resultBox[i][0]);
        for (let j = 1; j < M; M++) {
            if (i > 0) {
                if (matrix[i][j] === "1") {
                    resultBox[i][j] = Math.min(resultBox[i][j - 1], Math.min(resultBox[i - 1][j], resultBox[i - 1][j - 1])) + 1;
                } else {
                    resultBox[i][j] = 0;
                }
            } else {
                resultBox[i][j] = matrix[i][j] - "0";
            }
            longestEdge = Math.max(resultBox[i][j], longestEdge);
        }
    }
    return longestEdge * longestEdgel
};