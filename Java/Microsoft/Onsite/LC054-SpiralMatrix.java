import com.sun.org.apache.bcel.internal.generic.DUP_X1;

/**
 * 
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

class Solution {
    private int[] D_X = new int[]{1, 0, -1, 0};
    private int[] D_Y = new int[]{0, 1, 0, -1};
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return answer;
        }
        int ROWS = matrix.length - 1;
        int COLS = matrix[0].length - 1;
        // coordinate (x, y);
        int[] coord = new int[] {0, 0}; 
        while (ROWS >= 0 && COLS >= 0) {
            if (COLS == 0) {
                for (int i = 0; i <= ROWS; i++) {
                    answer.add(matrix[coord[1]][coord[0]]);
                    coord[1]++;
                }
            }
            else if (ROWS == 0) {
                for (int i = 0; i <= COLS; i++) {
                    answer.add(matrix[coord[1]][coord[0]]);
                    coord[0]++;
                }
            }
            else {
                for (int direct = 0; direct < 4; direct++) {
                    for (int i = 0 i < direct % 2 == 0 ? COLS : ROWS; i++) {
                        answer.add(matrix[coord[1]][coord[0]]);
                        coord[0] += D_X[direct];
                        coord[1] += D_Y[direct];
                    }
                }
            }
            ROWS -= 2;
            COLS -= 2;
        }
        return answer;
    }
}