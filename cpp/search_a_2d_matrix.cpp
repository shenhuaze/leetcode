#include <iostream>
#include <vector>

using namespace std;

bool SearchMatrix(vector<vector<int>>& matrix, int target) {
    if (matrix.empty() || matrix[0].empty()) {
        return false;
    }
    int m = matrix.size();
    int n = matrix[0].size();
    int start = 0;
    int end = m * n - 1;
    while (start + 1 < end) {
        int mid = (start + end) / 2;
        if (matrix[mid / n][mid % n] < target) {
            start = mid;
        } else if (matrix[mid / n][mid % n] > target) {
            end = mid;
        } else {
            return true;
        }
    }
    return (matrix[start / n][start % n] == target || matrix[end / n][end % n] == target);
}

int main() {
    vector<vector<int>> matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
    };
    int target = 3;
    cout << SearchMatrix(matrix, target);
    return 0;
}