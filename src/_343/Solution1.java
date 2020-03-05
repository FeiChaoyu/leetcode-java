package _343;

import java.util.Arrays;

/**
 * Memory Search
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 *
 * @author feichaoyu
 */
public class Solution1 {

    private int[] memo;

    public int integerBreak(int n) {

        if (n < 1) {
            throw new IllegalArgumentException("n should be greater than zero");
        }

        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return breakInteger(n);
    }

    private int breakInteger(int n) {

        if (n == 1) {
            return 1;
        }

        // memo中有值则不进行下面的递归
        if (memo[n] != -1) {
            return memo[n];
        }

        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            // 求 之前结果、不对n-i再次分割、对n-i再次分割 三者中最大值
            res = max3(res, i * (n - i), i * breakInteger(n - i));
        }
        // memo记忆当前值
        memo[n] = res;
        return res;
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {

        System.out.println((new Solution1()).integerBreak(2));
        System.out.println((new Solution1()).integerBreak(10));
    }
}
