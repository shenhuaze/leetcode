package com.huaze.shen;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Huaze Shen
 * @date 2019-07-16
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        return isValidRow(board) && isValidColumn(board) && isValidSubBox(board);
    }

    private boolean isValidRow(char[][] board) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < size; j++) {
                char ch = board[i][j];
                if (ch == '.') {
                    continue;
                }
                if (set.contains(ch)) {
                    return false;
                }
                set.add(ch);
            }
        }
        return true;
    }

    private boolean isValidColumn(char[][] board) {
        int size = board.length;
        for (int i = 0; i < size; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < size; j++) {
                char ch = board[j][i];
                if (ch == '.') {
                    continue;
                }
                if (set.contains(ch)) {
                    return false;
                }
                set.add(ch);
            }
        }
        return true;
    }

    private boolean isValidSubBox(char[][] board) {
        int size = board.length;
        int numSubBox = 3;
        int subSize = size / numSubBox;
        for (int i = 0; i < numSubBox; i++) {
            for (int j = 0; j < numSubBox; j++) {
                Set<Character> set = new HashSet<>();
                int rowStart = i * subSize;
                int colStart = j * subSize;
                for (int k = 0; k < subSize; k++) {
                    for (int l = 0; l < subSize; l++) {
                        char ch = board[rowStart + k][colStart + l];
                        if (ch == '.') {
                            continue;
                        }
                        if (set.contains(ch)) {
                            return false;
                        }
                        set.add(ch);
                    }
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
        System.out.println(new ValidSudoku().isValidSudoku(board));
    }
}
