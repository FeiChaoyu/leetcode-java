package _3;

/**
 * 滑动窗口
 *
 * @author feichaoyu
 */
public class Solution1 {

    public int lengthOfLongestSubstring(String s) {

        int sLen = s.length();
        char[] charArrayS = s.toCharArray();

        // 最多128个ASCII码字符
        int[] winFreq = new int[128];

        // sliding window: s[left...right)
        int left = 0, right = 0;
        int maxLen = 0;

        while (right < sLen) {
            char charRight = charArrayS[right];
            // 右边界字符没有出现过
            if (winFreq[charRight] == 0) {
                winFreq[charRight]++;
                right++;
            }
            // 右边界字符之前已经出现过
            else {
                // 左边界右移直到滑动窗口中不包含重复字符
                while (winFreq[charRight] != 0) {
                    char charLeft = charArrayS[left];
                    winFreq[charLeft]--;
                    left++;
                }
            }

            maxLen = Math.max(maxLen, right - left);

        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println((new Solution1()).lengthOfLongestSubstring("abcabcbb"));
        System.out.println((new Solution1()).lengthOfLongestSubstring("bbbbb"));
        System.out.println((new Solution1()).lengthOfLongestSubstring("pwwkew"));
        System.out.println((new Solution1()).lengthOfLongestSubstring(""));
    }
}
