/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

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
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
          return answer;
        }
        int[] DIRECT_X = new int[]{1, 0, -1, 0};
        int[] DIRECT_Y = new int[]{0, 1, 0, -1};
        // coordinate for (x, y)
        int[] coordinate = new int[]{0, 0};
        int M = matrix.length - 1, N = matrix[0].length - 1;
        while (M >= 0 && N >= 0) {
            if (M == 0) {
                for (int index = 0; index <= N; index++) {
                    answer.add(matrix[coordinate[1]][coordinate[0]]);
                    coordinate[0]++;
                }
            }
            else if (N == 0) {
                for (int index = 0; index <= M; index++) {
                    answer.add(matrix[coordinate[1]][coordinate[0]]);
                    coordinate[1]++;
                }
            }
            else {
                for (int direct = 0; direct < 4; direct++) {
                    for (int step = 0; step < (direct % 2 == 0 ? N : M); step++) {
                        answer.add(matrix[coordinate[1]][coordinate[0]]);
                        coordinate[0] += DIRECT_X[direct];
                        coordinate[1] += DIRECT_Y[direct];
                    }
                }
                coordinate[0]++;
                coordinate[1]++;
            }
            M -= 2;
            N -= 2;
        }
        return answer;
    }
}