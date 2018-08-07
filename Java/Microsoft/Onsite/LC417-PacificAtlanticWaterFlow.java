/**
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.

Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.

Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

Note:
The order of returned grid coordinates does not matter.
Both m and n are less than 150.
Example:

Given the following 5x5 matrix:

  Pacific ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * Atlantic

Return:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
 */

class Solution {
    private int[] D_X = new int[]{1, 0, -1, 0};
    private int[] D_Y = new int[]{0, 1, 0, -1};
    
    private void dfs(int[][] matrix, boolean[][] isVisited, int preHeight, int row, int col) {
        if (row < 0 || row >= matrix.length 
            || col < 0 || col >= matrix[0].length 
            || isVisited[row][col] || preHeight > matrix[row][col]) {
            return;
        }
        isVisited[row][col] = true;
        for (int di = 0; di < 4; di++) {
            dfs(matrix, isVisited, matrix[row][col], row + D_Y[di], col + D_X[di]);
        }
    }
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> answer = new ArrayList<int[]>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return answer;
        }
        int ROWS = matrix.length;
        int COLS = matrix[0].length;
        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];
        for (int index = 0; index < ROWS; index++) {
            dfs(matrix, pacific, -1, index, 0);
            dfs(matrix, atlantic, -1, index, COLS - 1);
        }
        for (int index = 0; index < COLS; index++) {
            dfs(matrix, atlantic, -1, ROWS - 1, index);
            dfs(matrix, pacific, -1, 0, index);
        }
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (atlantic[row][col] && pacific[row][col]) {
                    answer.add(new int[]{row, col});
                }
            }
        }
        return answer;
    }
}