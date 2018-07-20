import java.util.Queue;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 */

public class Solution {
    
    private int[] DIRECT_X = {1, 0, -1, 0};
    private int[] DIRECT_Y = {0, 1, 0, -1};
    public int numIslands(char[][] grid) {
        int answer = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return answer;
        }
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == '1') {
                    markIsland(grid, x, y);
                    answer++;
                }
            }
        }
        return answer;
    }

    private void markIsland(char[][] grid, int x, int y) {
        if (!isInbound(grid, x, y) || grid[y][x] != '1') {
            return;
        }
        grid[y][x] = 'n';
        for (int directIndex = 0; directIndex < 4; directIndex++) {
            markIsland(grid, x + DIRECT_X[directIndex], y + DIRECT_Y[directIndex]);
        }
    }

    private boolean isInbound(char[][] grid, int x, int y) {
        return x >= 0 && x < grid[0].length && y >= 0 && y < grid.length;
    }
}