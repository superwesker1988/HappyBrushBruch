/**
 * 
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Example:

Input: 
words = ["oath","pea","eat","rain"] and board =
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Output: ["eat","oath"]
Note:
You may assume that all inputs are consist of lowercase letters a-z.
 */

class Solution {
    class TrieNode {
        boolean isEndOfWord;
        Map<Character, TrieNode> children;
        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            isEndOfWord = false;
        }
    }
    
    class TrieTree {
        TrieNode root;
        public TrieTree() {
            root = new TrieNode();
        }
        
        public void insert(String word) {
            char[] wordChars = word.toCharArray();
            TrieNode triePointer = this.root;
            for (char wordChar : wordChars) {
                if (!triePointer.children.containsKey(wordChar)) {
                    triePointer.children.put(wordChar, new TrieNode());
                }
                triePointer = triePointer.children.get(wordChar);
            }
            triePointer.isEndOfWord = true;
        }
    }
    
    private int[] D_X = {1, 0, -1, 0};
    private int[] D_Y = {0, 1, 0, -1};
    
    private boolean isInbound(char[][] board, int x, int y) {
        return y >= 0 && y < board.length && x >= 0 && x < board[0].length;
    }
    
    private void search(char[][] board, TrieNode root, int x, int y, String curWord, List<String> answer) {
        if (!root.children.containsKey(board[y][x])) {
            return;
        }
        TrieNode curChild = root.children.get(board[y][x]);
        String newWord = curWord + board[y][x];
        if (curChild.isEndOfWord) {
            answer.add(newWord);
            curChild.isEndOfWord = false;
        }
        char curChar = board[y][x];
        board[y][x] = 0;
        for (int direct = 0; direct < 4; direct++) {
            int row = y + D_Y[direct];
            int col = x + D_X[direct];
            if (!isInbound(board, col, row) || board[row][col] == 0) {
                continue;
            }
            search(board, curChild, col, row, newWord, answer);
        }
        board[y][x] = curChar;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> answer = new ArrayList<String>();
        if (words == null || words.length == 0) {
            return answer;
        }
        TrieTree searchTree = new TrieTree();
        for (String word : words) {
            searchTree.insert(word);
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                search(board, searchTree.root, col, row, "", answer);
            }
        }
        return answer;
    }
}