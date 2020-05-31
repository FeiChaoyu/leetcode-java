package _62;

import java.util.Arrays;

/**
 * 一维DP
 * 使用二维数组的时候，dp[i][j] = dp[i-1][j] + dp[i][j-1] ，每一个格子的数据等于上面一个格子加左边格子的数据。
 * 可以想象一下，计算一行数据的时候，直接把上面一行的数据搬下来，然后每个格子就等于前一个格子的数据加上当前格子的数据。
 *
 * @author feichaoyu
 */
public class Solution3 {

    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }
}
