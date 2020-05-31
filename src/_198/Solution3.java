package _198;

/**
 * DP
 * 状态定义：dp[i]表示偷取[0...x]范围内的房子所获取的金额
 * 转移方程：dp[i] = max{dp[i-1], nums[i] + dp[i-2] }
 *
 * @author feichaoyu
 */
public class Solution3 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            // 1.不偷取当前这一家，那么就是第(i-1)家偷取的金额
            // 2.偷取当前这一家加上第(i-2)家共获取的金额
            // 两者取最大值
            dp[i] = Math.max(dp[i - 1], nums[i] + (i - 2 >= 0 ? dp[i - 2] : 0));
        }
        return dp[n - 1];
    }
}
