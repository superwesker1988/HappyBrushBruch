/**
 * 
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input: 
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output: 
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input: 
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output: 
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        // Invalid input
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        boolean isFirstRowZero = false;
        boolean isFirstColumnZero = false;
        int ROWS = matrix.length, COLS = matrix[0].length;
        // Determines whether first row and column need to be zero
        for (int row = 0; row < ROWS; row++) {
            if (matrix[row][0] == 0) {
                isFirstColumnZero = true;
                break;
            }
        }
        for (int col = 0; col < COLS; col++) {
            if (matrix[0][col] == 0) {
                isFirstRowZero = true;
                break;
            }
        }

        // Stores rows or columns need to be zero at first row and frist column
        for (int row = 1; row < ROWS; row++) {
            for (int col = 1; col < COLS; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }
        // Marks all the cells except first row and frist column
        for (int row = 1; row < ROWS; row++) {
            for (int col = 1; col < COLS; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }
        // Marks first row
        if (isFirstRowZero) {
            for (int col = 0; col < COLS; col++) {
                matrix[0][col] = 0;
            }
        }
        // Marks first column
        if (isFirstColumnZero) {
            for (int row = 0; row < ROWS; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}