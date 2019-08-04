#include <iostream>
#include <vector>

using namespace std;

vector<int> SpiralOrder(vector<vector<int>>& matrix) {
    vector<int> result;
    if (matrix.empty()) {
        return result;
    }
    int m = (int)matrix.size();
    int n = (int)matrix[0].size();
    int up = 0;
    int down = m - 1;
    int left = 0;
    int right = n - 1;
    while (up < down && left < right) {
        for (int i = left; i <= right; i++) {
            result.push_back(matrix[up][i]);
        }
        for (int i = up + 1; i <= down; i++) {
            result.push_back(matrix[i][right]);
        }
        for (int i = right - 1; i >= left; i--) {
            result.push_back(matrix[down][i]);
        }
        for (int i = down - 1; i >= up + 1; i--) {
            result.push_back(matrix[i][left]);
        }
        up += 1;
        down -= 1;
        left += 1;
        right -= 1;
    }
    if (up == down) {
        for (int i = left; i <= right; i++) {
            result.push_back(matrix[up][i]);
        }
    } else if (left == right) {
        for (int i = up; i <= down; i++) {
            result.push_back(matrix[i][left]);
        }
    }
    return result;
}

int main() {
    vector<vector<int>> matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
    };
    vector<int> result = SpiralOrder(matrix);
    for (int i : result) {
        cout << i << ", ";
    }
    return 0;
}