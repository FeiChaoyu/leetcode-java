package _63;

/**
 * 记忆化搜索
 * 代码应该没错，但是超时了！
 *
 * @author feichaoyu
 */
public class Solution1 {

    int[][] memo;
    int row, column;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        row = m;
        column = n;
        memo = new int[m][n];
        return calcTotal(0, 0, obstacleGrid);
    }

    public int calcTotal(int i, int j, int[][] obstacleGrid) {
        if (i == row - 1 && j == column - 1) {
            if (obstacleGrid[i][j] == 1) {
                return 0;
            }
            return 1;
        }

        if (obstacleGrid[i][j] == 1) {
            return 0;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int below = 0;
        int right = 0;
        if (i != row - 1 && obstacleGrid[i + 1][j] != 1) {
            below = calcTotal(i + 1, j, obstacleGrid);
        }
        if (j != column - 1 && obstacleGrid[i][j + 1] != 1) {
            right = calcTotal(i, j + 1, obstacleGrid);
        }

        memo[i][j] = below + right;

        return memo[i][j];
    }
}
