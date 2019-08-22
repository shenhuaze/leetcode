

def unique_paths_with_obstacles(obstacle_grid):
    if obstacle_grid is None or len(obstacle_grid) == 0 or obstacle_grid[0] is None or len(obstacle_grid[0]) == 0:
        return 0
    m = len(obstacle_grid)
    n = len(obstacle_grid[0])
    dp = [0 for i in range(n)]
    for i in range(n):
        if obstacle_grid[0][i] == 0:
            dp[i] = 1
        else:
            break
    first_vertical_elements = [0 for i in range(m)]
    for i in range(m):
        if obstacle_grid[i][0] == 0:
            first_vertical_elements[i] = 1
        else:
            break
    for i in range(1, m):
        dp[0] = first_vertical_elements[i]
        for j in range(1, n):
            if obstacle_grid[i][j] == 1:
                dp[j] = 0
            else:
                dp[j] += dp[j - 1]
    return dp[n - 1]


if __name__ == '__main__':
    obstacle_grid_ = [
        [0, 0, 0],
        [0, 1, 0],
        [0, 0, 0]
    ]
    print(unique_paths_with_obstacles(obstacle_grid_))
