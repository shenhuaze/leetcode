package com.huaze.shen;

/**
 * @author Huaze Shen
 * @date 2019-07-17
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        solveSudokuDFS(board, 0, 0);
    }

    private boolean solveSudokuDFS(char[][] board, int i, int j) {
        if (i == 9) {
            return true;
        }
        if (j >= 9) {
            return solveSudokuDFS(board, i + 1, 0);
        }
        if (board[i][j] == '.') {
            for (char k = '1'; k <= '9'; k++) {
                board[i][j] = k;
                if (isValid(board, i, j)) {
                    if (solveSudokuDFS(board, i, j + 1)) {
                        return true;
                    }
                }
                board[i][j] = '.';
            }
        } else {
            return solveSudokuDFS(board, i, j + 1);
        }
        return false;
    }

    private boolean isValid(char[][] board, int i, int j) {
        for (int col = 0; col < 9; col++) {
            if (col != j && board[i][j] == board[i][col]) {
                return false;
            }
        }
        for (int row = 0; row < 9; row++) {
            if (row != i && board[i][j] == board[row][j]) {
                return false;
            }
        }
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
                if (row != i && col != j && board[i][j] == board[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new SudokuSolver().solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
