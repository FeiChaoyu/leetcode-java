package _322;

import java.util.Arrays;

/**
 * DP
 * 定义状态：dp[i]表示的凑成总金额为i所需的最少的硬币个数
 * 状态转移：dp[i] = min{dp[i-coins[j]]} + 1, 其中coins[j]表示第j枚硬币的面值
 * <p>
 * 例如：coins = [1, 2, 5], amount = 11
 * dp[0]     0
 * dp[1]     dp[1] = min{dp[1-1], dp[1-2], dp[1-5]} + 1 = 1
 * dp[2]     dp[2] = min{dp[2-1], dp[2-2], dp[2-5]} + 1 = 1
 * dp[3]     dp[3] = min{dp[3-1], dp[3-2], dp[3-5]} + 1 = 2
 * ...
 * dp[11]    dp[11] = min{dp[11-1], dp[11-2], dp[11-5]} + 1 = 3
 *
 * @author feichaoyu
 */
public class Solution2 {

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        // 不能取Integer.MAX_VALUE，下面+1会溢出
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(new Solution2().coinChange(coins, 11));
    }
}
