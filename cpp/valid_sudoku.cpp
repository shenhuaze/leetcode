#include <iostream>
#include <vector>
#include <set>

using namespace std;

/**
 * @author Huaze Shen
 * @date 2019-07-16
 */
bool IsValidRow(vector<vector<char>>& board) {
    int size = board.size();
    for (int i = 0; i < size; i++) {
        set<char> s;
        for (int j = 0; j < size; j++) {
            char ch = board[i][j];
            if (ch == '.') {
                continue;
            }
            if (s.count(ch)) {
                return false;
            }
            s.insert(ch);
        }
    }
    return true;
}

bool IsValidColumn(vector<vector<char>>& board) {
    int size = board.size();
    for (int i = 0; i < size; i++) {
        set<char> s;
        for (int j = 0; j < size; j++) {
            char ch = board[j][i];
            if (ch == '.') {
                continue;
            }
            if (s.count(ch)) {
                return false;
            }
            s.insert(ch);
        }
    }
    return true;
}

bool IsValidSubBox(vector<vector<char>>& board) {
    int size = board.size();
    int num_sub_box = 3;
    int sub_size = size / num_sub_box;
    for (int i = 0; i < num_sub_box; i++) {
        for (int j = 0; j < num_sub_box; j++) {
            set<char> s;
            int row_start = i * sub_size;
            int col_start = j * sub_size;
            for (int k = 0; k < sub_size; k++) {
                for (int l = 0; l < sub_size; l++) {
                    char ch = board[row_start + k][col_start + l];
                    if (ch == '.') {
                        continue;
                    }
                    if (s.count(ch)) {
                        return false;
                    }
                    s.insert(ch);
                }
            }
        }
    }
    return true;
}

bool IsValidSudoku(vector<vector<char>>& board) {
    return IsValidRow(board) && IsValidColumn(board) && IsValidSubBox(board);
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
    cout << IsValidSudoku(board);
    return 0;
}