package _5;

/**
 * 动态规划
 * 定义状态：dp[i][j] 表示子串 s[i, j] 是否为回文子串
 * 状态转移方程：dp[i][j] = (s[i] == s[j]) and dp[i + 1][j - 1]
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 *
 * @author feichaoyu
 */
public class Solution2 {

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int maxLen = 1;
        int start = 0;

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 边界条件
                    // [i + 1, j - 1] 不构成区间，即长度小于 2，即 j - 1 - (i + 1) + 1 < 2 ，整理得 j - i < 3
                    // 在此情况下，当 s[i, j] 的长度等于 2 或者等于 3 的时候，子串要么为空，要么只有 1 个字符，这两种情况子串都是回文
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i, j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j]) {
                    int curLen = j - i + 1;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
