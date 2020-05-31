package _63;

/**
 * 二维DP
 * dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
 *
 * @author feichaoyu
 */
public class Solution2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        // 第一个格子是障碍物，则无法移动
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        dp[0][0] = 1;

        // 最左侧一列，只能向下
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                // 这里不能直接设置为 dp[i][0] = 1，因为有可能上边的值是0（有障碍），但是当前值是1（无障碍），
                // 但是此时是无法到达该点的，因此应该设置为 dp[i][0] = dp[i - 1][0]
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = 0;
            }
        }

        // 最上面一行，只能向右
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                // 这里不能直接设置为 dp[0][j] = 1，因为有可能左边的值是0（有障碍），但是当前值是1（无障碍），
                // 但是此时是无法到达该点的，因此应该设置为 dp[0][j] = dp[0][j - 1]
                dp[0][j] = dp[0][j - 1];
            } else {
                dp[0][j] = 0;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }

            }
        }
        return dp[m - 1][n - 1];
    }
}
