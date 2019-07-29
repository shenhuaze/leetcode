#include <iostream>
#include <vector>

using namespace std;

/**
 * @author Huaze Shen
 * @date 2019-07-27
 */
vector<string> DrawChessboard(vector<int>& cols) {
    vector<string> chessboard;
    for (int i = 0; i < cols.size(); i++) {
        string row;
        for (int j = 0; j < cols.size(); j++) {
            if (cols[i] == j) {
                row += "Q";
            } else {
                row += ".";
            }
        }
        chessboard.push_back(row);
    }
    return chessboard;
}

bool IsValid(vector<int>& cols, int column) {
    int current_size = (int)cols.size();
    for (int i = 0; i < current_size; i++) {
        if (column == cols[i]) {
            return false;
        }
        if (i + cols[i] == current_size + column) {
            return false;
        }
        if (i - cols[i] == current_size - column) {
            return false;
        }
    }
    return true;
}

void Search(vector<vector<string>>& results, vector<int>& cols, int n) {
    if (cols.size() == n) {
        results.push_back(DrawChessboard(cols));
        return;
    }
    for (int i = 0; i < n; i++) {
        if (!IsValid(cols, i)) {
            continue;
        }
        cols.push_back(i);
        Search(results, cols, n);
        cols.pop_back();
    }
}

vector<vector<string>> SolveNQueens(int n) {
    vector<vector<string>> results;
    if (n <= 0) {
        return results;
    }
    vector<int> cols;
    Search(results, cols, n);
    return results;
}

int main() {
    vector<vector<string>> results = SolveNQueens(4);
    for (vector<string> row : results) {
        for (string each : row) {
            cout << each << "\n";
        }
        cout << "\n";
    }
    return 0;
}