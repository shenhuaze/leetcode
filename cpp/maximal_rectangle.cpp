#include <iostream>
#include <vector>

using namespace std;

int LargestRectangleArea(vector<int>& heights) {
    int result = 0;
    for (int i = 0; i < heights.size(); i++) {
        if (i < heights.size() - 1 && heights[i] <= heights[i + 1]) {
            continue;
        }
        int min_h = heights[i];
        for (int j = i; j >= 0; j--) {
            min_h = min(min_h, heights[j]);
            int area = min_h * (i - j + 1);
            result = max(area, result);
        }
    }
    return result;
}

int MaximalRectangle(vector<vector<char>>& matrix) {
    if (matrix.empty() || matrix[0].empty()) {
        return 0;
    }
    int m = matrix.size();
    int n = matrix[0].size();
    vector<int> heights(n, 0);
    int result = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (matrix[i][j] == '0') {
                heights[j] = 0;
            } else if (matrix[i][j] == '1'){
                heights[j] += 1;
            }
        }
        result = max(result, LargestRectangleArea(heights));
    }
    return result;
}

int main() {
    vector<vector<char>> matrix = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
    };
    cout << MaximalRectangle(matrix);
    return 0;
}