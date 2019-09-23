#include <iostream>
#include <vector>

using namespace std;

void SetZeroes(vector<vector<int>>& matrix) {
    int m = matrix.size();
    int n = matrix[0].size();
    bool first_row_is_zero = false;
    bool first_col_is_zero = false;
    for (int i = 0; i < n; i++) {
        if (matrix[0][i] == 0) {
            first_row_is_zero = true;
            break;
        }
    }
    for (int i = 0; i < m; i++) {
        if (matrix[i][0] == 0) {
            first_col_is_zero = true;
            break;
        }
    }
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                matrix[i][j] = 0;
            }
        }
    }
    if (first_row_is_zero) {
        for (int i = 0; i < n; i++) {
            matrix[0][i] = 0;
        }
    }
    if (first_col_is_zero) {
        for (int i = 0; i < m; i++) {
            matrix[i][0] = 0;
        }
    }
}

int main() {
    vector<vector<int>> matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
    };
    SetZeroes(matrix);
    for (vector<int> row: matrix) {
        for (int i: row) {
            cout << i << " ";
        }
        cout << "\n";
    }
    return 0;
}