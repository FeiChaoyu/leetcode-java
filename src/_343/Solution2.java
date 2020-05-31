package _343;

/**
 * Dynamic Programming
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 *
 * @author feichaoyu
 */
public class Solution2 {

    public int integerBreak(int n) {

        if (n < 1) {
            throw new IllegalArgumentException("n should be greater than zero");
        }

        // memo[i]表示将数字i分割后得到的最大乘积
        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 求解memo[i]
            for (int j = 1; j <= i - 1; j++) {
                // 将 i 分割成 j 和 (i - j)
                memo[i] = max3(memo[i], j * (i - j), j * memo[i - j]);
            }
        }

        return memo[n];
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {

        System.out.println((new Solution2()).integerBreak(2));
        System.out.println((new Solution2()).integerBreak(10));
    }
}
