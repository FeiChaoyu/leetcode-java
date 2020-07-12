package _0424;

/**
 * 滑动窗口
 *
 * @author feichaoyu
 */
public class Solution {

    // 本题若k=0的情况就是求解最长连续子串
    public int characterReplacement(String s, int k) {

        int sLen = s.length();
        if (sLen == 0 || sLen == 1) {
            return sLen;
        }

        char[] chars = s.toCharArray();
        // 只要求是大写字母
        int[] winFreq = new int[26];
        // 滑动窗口内出现相同字母次数的最大值，比如[AABA]，那么maxCount=3
        int maxCount = 0;
        int maxLen = 0;

        // sliding window: s[left...right)
        int left = 0;
        int right = 0;
        while (right < sLen) {
            int index = chars[right++] - 'A';
            winFreq[index]++;
            maxCount = Math.max(maxCount, winFreq[index]);

            // 需要替换的字符个数就是当前窗口的大小减去窗口中数量最多的字符的数量
            while (right - left - maxCount > k) {
                // 缩小窗口
                winFreq[chars[left] - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().characterReplacement("AABABBA", 1));
    }
}
