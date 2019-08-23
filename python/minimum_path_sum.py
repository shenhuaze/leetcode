

def min_path_sum(grid):
    if grid is None or len(grid) == 0 or grid[0] is None or len(grid[0]) == 0:
        return 0
    m = len(grid)
    n = len(grid[0])
    dp = [0 for i in range(n)]
    dp[0] = grid[0][0]
    for i in range(1, n):
        dp[i] = grid[0][i] + dp[i - 1]
    first_vertical_elements = [0 for i in range(m)]
    first_vertical_elements[0] = grid[0][0]
    for i in range(1, m):
        first_vertical_elements[i] = grid[i][0] + first_vertical_elements[i - 1]
    for i in range(1, m):
        dp[0] = first_vertical_elements[i]
        for j in range(1, n):
            dp[j] = grid[i][j] + min(dp[j - 1], dp[j])
    return dp[n - 1]


if __name__ == '__main__':
    grid_ = [[1, 3, 1], [1, 5, 1], [4, 2, 1]]
    print(min_path_sum(grid_))
