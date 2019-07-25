#include <iostream>
#include <vector>

using namespace std;

/**
 * @author Huaze Shen
 * @date 2019-07-25
 */
void Rotate(vector<vector<int>>& matrix) {
    if (matrix.empty()) {
        return;
    }
    int start = 0;
    int end = matrix.size() - 1;
    while (start < end) {
        int range = end - start;
        for (int i = 0; i < range; i++) {
            int temp = matrix[start][start + i];
            matrix[start][start + i] = matrix[end - i][start];
            matrix[end - i][start] = matrix[end][end - i];
            matrix[end][end - i] = matrix[start + i][end];
            matrix[start + i][end] = temp;
        }
        start += 1;
        end -= 1;
    }
}

int main() {
    vector<vector<int>> matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
    };
    Rotate(matrix);
    for (vector<int> row : matrix) {
        for (int i : row) {
            cout << i << " ";
        }
        cout << "\n";
    }
    return 0;
}