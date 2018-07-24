/**
 * Given an 2D board, count how many battleships are in it. The battleships are represented with 'X's, empty slots are represented with '.'s. You may assume the following rules:
You receive a valid board, made of only battleships or empty slots.
Battleships can only be placed horizontally or vertically. In other words, they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.
Example:
X..X
...X
...X
In the above board there are 2 battleships.
Invalid Example:
...X
XXXX
...X
This is an invalid board that you will not receive - as battleships will always have a cell separating between them.
Follow up:
Could you do it in one-pass, using only O(1) extra memory and without modifying the value of the board?
 */

class Solution {
    public int countBattleships(char[][] board) {
        int answer = 0;
        if (board == null || board.length == 0|| board[0].length == 0) {
            return answer;
        }

        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                // Skips water
                if (board[y][x] != 'X') {
                    continue;
                }
                // Determines if previous horizontal location is counted
                if (x > 0 && board[y][x - 1] == 'X') {
                    continue;
                }
                // Determines if previous vertical location is counted
                if (y > 0 && board[y - 1][x] == 'X') {
                    continue;
                }
                // Only counts number at the top-left of the ships
                answer++;
            }
        }

        return answer;
    }
}