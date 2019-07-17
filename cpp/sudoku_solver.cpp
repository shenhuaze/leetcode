#include <iostream>
#include <vector>

using namespace std;

/**
 * @author Huaze Shen
 * @date 2019-07-17
 */

bool IsValid(vector<vector<char>>& board, int i, int j) {
    for (int col = 0; col < 9; col++) {
        if (col != j && board[i][col] == board[i][j]) {
            return false;
        }
    }
    for (int row = 0; row < 9; row++) {
        if (row != i && board[row][j] == board[i][j]) {
            return false;
        }
    }
    for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
        for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
            if (row != i && col != j && board[row][col] == board[i][j]) {
                return false;
            }
        }
    }
    return true;
}

bool SolveSudokuDFS(vector<vector<char>>& board, int i, int j) {
    if (i == 9) {
        return true;
    }
    if (j >= 9) {
        return SolveSudokuDFS(board, i + 1, 0);
    }
    if (board[i][j] == '.') {
        for (int k = 1; k <= 9; k++) {
            board[i][j] = (char)(k + '0');
            if (IsValid(board, i, j)) {
                if (SolveSudokuDFS(board, i, j + 1)) {
                    return true;
                }
            }
            board[i][j] = '.';
        }
    } else {
        return SolveSudokuDFS(board, i, j + 1);
    }
    return false;
}


void SolveSudoku(vector<vector<char>>& board) {
    if (board.empty() || board.size() != 9 || board[0].size() != 9) {
        return;
    }
    SolveSudokuDFS(board, 0, 0);
}

int main() {
    vector<vector<char>> board = {
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
    SolveSudoku(board);
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            cout << board[i][j] << " ";
        }
        cout << "\n";
    }
    return 0;
}