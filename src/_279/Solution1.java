package _279;

/**
 * 记忆化搜索
 *
 * @author feichaoyu
 */
public class Solution1 {

    private int[] memo;

    public int numSquares(int n) {
        memo = new int[n + 1];
        return numSqu(n);
    }

    private int numSqu(int n) {
        int val = (int) Math.sqrt(n);
        // 当前数字就是完全平方数
        if (val * val == n) {
            return memo[n] = 1;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        int res = Integer.MAX_VALUE;
        for (int i = 1; i * i < n; i++) {
            res = Math.min(res, numSqu(n - i * i) + 1);
        }
        memo[n] = res;
        return res;
    }
}
