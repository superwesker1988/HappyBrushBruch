/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 7 x 3 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:

Input: m = 7, n = 3
Output: 28
 */

/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    if (m * n === 0) {
        return 0;
    }
    const dpMem = Array(n);
    for (let i = 0; i < n; i++) {
        dpMem[i] = Array(m).fill(i === 0 ? 1 :0);
        dpMem[i][0] = 1;
    }
    for (let row = 1; row < n; row++) {
        for (let col = 1; col < m; col++) {
            dpMem[row][col] = dpMem[row - 1][col] + dpMem[row][col - 1];
        }
    }
    return dpMem[n - 1][m - 1];
};