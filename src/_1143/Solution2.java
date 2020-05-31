package _1143;

import java.util.Arrays;

/**
 * DP
 * 定义状态：dp[i,j] 表示text1[0...i]和text2[0...j]中最长公共子序列的长度
 * 状态转移：
 * 1.若text1[i] == text2[j]，则dp[i,j] = 1 + dp[i-1,j-1]
 * 2.若text1[i] != text2[j]，则dp[i,j] = max{dp[i-1,j], dp[i,j-1]}
 *
 * @author feichaoyu
 */
public class Solution2 {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
