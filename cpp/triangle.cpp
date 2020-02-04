#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int MinimumTotal(vector<vector<int>>& triangle) {
    int m = triangle.size();
    vector<int> row(m);
    row[0] = triangle[0][0];
    for (int i = 1; i < m; i++) {
        for (int j = i; j >= 0; j--) {
            int min_value;
            if (j == 0) {
                min_value = row[j];
            } else if (j == i) {
                min_value = row[j - 1];
            } else {
                min_value = min(row[j - 1], row[j]);
            }
            row[j] = triangle[i][j] + min_value;
        }
    }
    int total_min = row[0];
    for (int i = 1; i < m; i++) {
        if (row[i] < total_min) {
            total_min = row[i];
        }
    }
    return total_min;
}

int main() {
    vector<vector<int>> triangle = {
            {2},
            {3, 4},
            {6, 5, 7},
            {4, 1, 8, 3}
    };
    cout << MinimumTotal(triangle);
    return 0;
}