#include <iostream>
#include <vector>

using namespace std;

bool Search(vector<vector<char>>& board, int i, int j, int m, int n, string word, int index) {
    if (index == word.size()) {
        return true;
    }
    if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '#' || board[i][j] != word[index]) {
        return false;
    }
    char ch = board[i][j];
    board[i][j] = '#';
    bool result = (Search(board, i - 1, j, m, n, word, index + 1) ||
            Search(board, i + 1, j, m, n, word, index + 1) ||
            Search(board, i, j - 1, m, n, word, index + 1) ||
            Search(board, i, j + 1, m, n, word, index + 1));
    board[i][j] = ch;
    return result;
}

bool Exist(vector<vector<char>>& board, string word) {
    if (board.empty() || board[0].empty()) {
        return false;
    }
    int m = board.size();
    int n = board[0].size();
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (Search(board, i, j, m, n, word, 0)) {
                return true;
            }
        }
    }
    return false;
}

int main() {
    vector<vector<char>> board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
    };
    string word = "ABCCED";
    cout << Exist(board, word);
    return 0;
}