package _91;

/**
 * DP
 * https://leetcode-cn.com/problems/decode-ways/solution/c-wo-ren-wei-hen-jian-dan-zhi-guan-de-jie-fa-by-pr/
 *
 * @author feichaoyu
 */
public class Solution2 {

    public int numDecodings(String s) {
        // 首字符不能是'0'
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            // 1.s[i]为0的情况
            if (s.charAt(i) == '0') {
                // s[i-1]等于1或2的情况
                if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    // 由于s[1]指第二个下标，对应为dp[2],所以dp的下标要比s大1，故为dp[i+1]
                    dp[i + 1] = dp[i - 1];
                }
                // 如果有一个字符为0，则它的前一个字符必须是1或者2，否则退出
                else {
                    return 0;
                }
            }
            // 2.s[i]不为0的情况
            else {
                // s[i-1]s[i]两位数小于26的情况
                if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6')) {
                    dp[i + 1] = dp[i] + dp[i - 1];
                }
                // 其他情况
                else {
                    dp[i + 1] = dp[i];
                }
            }
        }
        return dp[s.length()];
    }
}
