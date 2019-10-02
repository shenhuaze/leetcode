package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-09-30
 */
public class WordSearch {
    /**
     * Solution 1
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search(board, i, j, m, n, word, visited, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int i, int j, int m, int n,
                           String word, boolean[][] visited, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        visited[i][j] = true;
        boolean result = (search(board, i - 1, j, m, n, word, visited, index + 1) ||
                search(board, i + 1, j, m, n, word, visited, index + 1) ||
                search(board, i, j - 1, m, n, word, visited, index + 1) ||
                search(board, i, j + 1, m, n, word, visited, index + 1));
        visited[i][j] = false;
        return result;
    }

    /**
     * Solution 2
     */
    public boolean exist2(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (search2(board, i, j, m, n, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search2(char[][] board, int i, int j, int m, int n, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '#' || board[i][j] != word.charAt(index)) {
            return false;
        }
        char ch = board[i][j];
        board[i][j] = '#';
        boolean result = (search2(board, i - 1, j, m, n, word, index + 1) ||
                search2(board, i + 1, j, m, n, word, index + 1) ||
                search2(board, i, j - 1, m, n, word, index + 1) ||
                search2(board, i, j + 1, m, n, word, index + 1));
        board[i][j] = ch;
        return result;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(new WordSearch().exist(board, word));
        System.out.println(new WordSearch().exist2(board, word));
    }
}
