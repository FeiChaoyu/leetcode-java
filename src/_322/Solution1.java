package _322;

/**
 * 记忆化搜索
 *
 * @author feichaoyu
 */
public class Solution1 {

    /**
     * memo[n]表示钱币n+1可以被换取的最少的硬币数，不能换取就为-1
     */
    int[] memo;

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }

        if (amount < 1) {
            return 0;
        }

        memo = new int[amount];
        return findWay(coins, amount);
    }

    public int findWay(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        if (memo[amount - 1] != 0) {
            return memo[amount - 1];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = findWay(coins, amount - coin);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount - 1];
    }
}
