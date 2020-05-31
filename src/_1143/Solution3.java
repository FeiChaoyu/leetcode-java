package _1143;

/**
 * DP
 * 定义状态：dp[i,j] 表示text1[i...m-1]和text2[j...n-1]中最长公共子序列的长度
 * 状态转移：
 * 1.若text1[i] == text2[j]，则dp[i,j] = 1 + dp[i+1,j+1]
 * 2.若text1[i] != text2[j]，则dp[i,j] = max{dp[i+1,j], dp[i,j+1]}
 *
 * @author feichaoyu
 */
public class Solution3 {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] dp = new int[m + 1][n + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }
}
