package _279;

/**
 * DP
 * 递推式：dp[i] = min{dp[i], dp[i-j*j]+1}
 *
 * @author feichaoyu
 */
public class Solution2 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 最坏的情况就是完全平方数全部由1组成，此时dp[i]=i
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
