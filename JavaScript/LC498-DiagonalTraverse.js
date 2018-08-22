/**
 * 
Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

Example:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output:  [1,2,4,7,5,3,6,8,9]
Explanation:

Note:
The total number of elements of the given matrix will not exceed 10,000.
 */

/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var findDiagonalOrder = function(matrix) {
    if (!matrix || matrix.length === 0) {
        return [];
    }
    const ROWS = matrix.length + matrix[0].length - 1;
    const answer = [];
    for (let i = 0; i < ROWS; i++) {
        const lowBound = Math.max(0, i - matrix[0].length + 1);
        const highBound = Math.min(i, matrix.length - 1);
        if (i % 2 === 0) {
            for (let j = highBound; j >= lowBound; j--) {
                answer.push(matrix[j][i - j]);
            }
        } else {
            for (let j = lowBound; j <= highBound; j++) {
                answer.push(matrix[j][i - j]);
            }
        }
    }
    return answer;
};