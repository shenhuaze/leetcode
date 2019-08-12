#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> GenerateMatrix(int n) {
    vector<vector<int>> results;
    for (int i = 0; i < n; i++) {
        vector<int> row;
        for (int j = 0; j < n; j++) {
            row.push_back(0);
        }
        results.push_back(row);
    }
    int left = 0;
    int right = n - 1;
    int up = 0;
    int down = n - 1;
    int current_num = 1;
    while (left < right && up < down) {
        for (int i = left; i <= right; i++) {
            results[up][i] = current_num++;
        }
        for (int i = up + 1; i <= down; i++) {
            results[i][right] = current_num++;
        }
        for (int i = right - 1; i >= left; i--) {
            results[down][i] = current_num++;
        }
        for (int i = down - 1; i >= up + 1; i--) {
            results[i][left] = current_num++;
        }
        left += 1;
        right -= 1;
        up += 1;
        down -= 1;
    }
    if (up == down) {
        for (int i = left; i <= right; i++) {
            results[up][i] = current_num++;
        }
    } else if (left == right) {
        for (int i = up; i <= down; i++) {
            results[i][left] = current_num++;
        }
    }
    return results;
}

int main() {
    int n = 5;
    vector<vector<int>> results = GenerateMatrix(n);
    for (vector<int> row : results) {
        for (int i : row) {
            cout << i << " ";
        }
        cout << "\n";
    }
    return 0;
}