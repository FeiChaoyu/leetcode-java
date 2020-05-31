package _91;

import java.util.Arrays;

/**
 * 记忆化搜索
 * <p>
 * 如果为7。很显然是1种7->G
 * 如果为67。很显然还是1种67->FG
 * 如果为067。结果为0。
 * 如果为2067。 结果为numDecodings（2 067）+ numDecodings（20 67）= numDecodings（20 67）->TFG
 * 如果为22067。 结果为numDecodings（2 2067）+ numDecodings（22 067）= numDecodings（2 2067）->BTFG
 * <p>
 * 从中，我们可以看出规律。
 * 如果开始的数为0，结果为0。
 * 如果开始的数加上第二个数小于等于26。结果为 numDecodings（start+1）+ numDecodings（start +2）
 * 如果开始的数加上第二个数大于26。结果为 numDecodings（start +1）
 * <p>
 * https://leetcode-cn.com/problems/decode-ways/solution/java-di-gui-dong-tai-gui-hua-kong-jian-ya-suo-by-r/
 *
 * @author feichaoyu
 */
public class Solution1 {

    private int[] memo;

    public int numDecodings(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return calcWays(0, s);
    }

    private int calcWays(int index, String s) {

        if (s.length() == index) {
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        if (memo[index] == -1) {
            memo[index] = calcWays(index + 1, s);
            if (index < s.length() - 1) {
                int ten = (s.charAt(index) - '0') * 10;
                int one = (s.charAt(index + 1) - '0');
                if (ten + one <= 26) {
                    memo[index] += calcWays(index + 2, s);
                }
            }
        }
        return memo[index];
    }

    public static void main(String[] args) {

        System.out.println((new Solution1()).numDecodings("226"));
    }
}
