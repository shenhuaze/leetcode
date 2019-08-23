#include <iostream>
#include <vector>

using namespace std;

int MinPathSum(vector<vector<int>>& grid) {
    if (grid.empty() || grid[0].empty()) {
        return 0;
    }
    int m = (int)grid.size();
    int n = (int)grid[0].size();
    vector<int> dp(n, 0);
    dp[0] = grid[0][0];
    for (int i = 1; i < n; i++) {
        dp[i] = grid[0][i] + dp[i - 1];
    }
    vector<int> first_vertical_elements(m, 0);
    first_vertical_elements[0] = grid[0][0];
    for (int i = 1; i < m; i++) {
        first_vertical_elements[i] = grid[i][0] + first_vertical_elements[i - 1];
    }
    for (int i = 1; i < m; i++) {
        dp[0] = first_vertical_elements[i];
        for (int j = 1; j < n; j++) {
            dp[j] = grid[i][j] + min(dp[j - 1], dp[j]);
        }
    }
    return dp[n - 1];
}

int main() {
    vector<vector<int>> grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
    };
    cout << MinPathSum(grid);
    return 0;
}