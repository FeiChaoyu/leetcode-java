package _64;

/**
 * 一维DP
 * dp[j] = min{dp[j], dp[j+1]} + grid[i][j]
 *
 * @author feichaoyu
 */
public class Solution3 {

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[] dp = new int[column];
        for (int i = row - 1; i >= 0; i--) {
            for (int j = column - 1; j >= 0; j--) {
                // 1.最后一行，只能向右
                if (i == row - 1 && j != column - 1) {
                    dp[j] = grid[i][j] + dp[j + 1];
                }
                // 2.最后一列，只能向下
                else if (j == column - 1 && i != row - 1) {
                    dp[j] = grid[i][j] + dp[j];
                }
                // 3.到达右下角
                else if (j == column - 1 && i == row - 1) {
                    dp[j] = grid[i][j];
                }
                // 4.正常情况
                else {
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                }
            }
        }
        return dp[0];
    }
}
