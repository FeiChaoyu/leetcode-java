package _1143;

/**
 * 记忆化搜索
 *
 * @author feichaoyu
 */
public class Solution1 {

    private int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m == 0 || n == 0) {
            return 0;
        }
        memo = new int[m][n];
        return getMaxLength(text1, text2, m - 1, n - 1);
    }

    private int getMaxLength(String text1, String text2, int i, int j) {

        if (i < 0 || j < 0) {
            return 0;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        // 从最后开始逐个字符地比较这两个字符串，如果字符相等，则同时向前缩一位，再次比较
        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + getMaxLength(text1, text2, i - 1, j - 1);
        }

        // 如果两个字符不相等，则字符1向前缩一位，字符2不动 或者 字符1不动，字符2向前缩一位，取最终结果的最大值
        if (text1.charAt(i) != text2.charAt(j)) {
            memo[i][j] = Math.max(getMaxLength(text1, text2, i - 1, j), getMaxLength(text1, text2, i, j - 1));
        }

        return memo[i][j];
    }
}
