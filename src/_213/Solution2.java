package _213;

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

        if (n == 1) {
            return nums[0];
        }

        // 1.头尾两家都不被抢
        // 2.第一间房子被抢最后一间不抢
        // 3.最后一间房子被抢第一间不抢
        // 实际上，情况2和3已经包含了情况1，所以只需要求解情况2和3中最大值即可
        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }

    // 仅计算闭区间 [start,end] 的最优结果
    int robRange(int[] nums, int start, int end) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[end] = nums[end];
        for (int i = end - 1; i >= start; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + (i + 2 < n ? dp[i + 2] : 0));
        }
        return dp[start];
    }

    public static void main(String[] args) {

        int[] nums = {4, 2, 3, 4};
        System.out.println((new _213.Solution2()).rob(nums));
    }
}
