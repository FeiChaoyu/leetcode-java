package _198;

/**
 * DP
 * 状态定义：dp[i]表示偷取[x...n-1]范围内的房子所获取的金额
 * 转移方程：dp[i] = max{dp[i+1], nums[i] + dp[i+2] }
 *
 * @author feichaoyu
 */
public class Solution2 {

    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n];
        dp[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            // 1.不偷取当前这一家，那么就是第(i+1)家偷取的金额
            // 2.偷取当前这一家加上第(i+2)家共获取的金额
            // 两者取最大值
            dp[i] = Math.max(dp[i + 1], nums[i] + (i + 2 < n ? dp[i + 2] : 0));
        }

        return dp[0];
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 9, 3, 1};
        System.out.println((new Solution2()).rob(nums));
    }
}
