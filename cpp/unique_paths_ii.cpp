#include <iostream>
#include <vector>

using namespace std;

int UniquePathsWithObstacles(vector<vector<int>>& obstacle_grid) {
    if (obstacle_grid.empty() || obstacle_grid[0].empty()) {
        return 0;
    }
    int m = (int)obstacle_grid.size();
    int n = (int)obstacle_grid[0].size();
    vector<long> dp(n, 0);
    for (int i = 0; i < n; i++) {
        if (obstacle_grid[0][i] == 1) {
            break;
        } else {
            dp[i] = 1;
        }
    }
    vector<long> first_vertical_elements(m, 0);
    for (int i = 0; i < m; i++) {
        if (obstacle_grid[i][0] == 1) {
            break;
        } else {
            first_vertical_elements[i] = 1;
        }
    }
    for (int i = 1; i < m; i++) {
        dp[0] = first_vertical_elements[i];
        for (int j = 1; j < n; j++) {
            if (obstacle_grid[i][j] == 1) {
                dp[j] = 0;
            } else {
                dp[j] += dp[j - 1];
            }
        }
    }
    return dp[n - 1];
}

int main() {
    vector<vector<int>> obstacle_grid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
    };
    cout << UniquePathsWithObstacles(obstacle_grid);
    return 0;
}