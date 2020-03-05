package _3;

/**
 * Sliding Window
 * Time Complexity: O(len(s))
 * Space Complexity: O(len(charset))
 *
 * @author feichaoyu
 */
// 其他方法：https://github.com/liuyubobobo/Play-Leetcode/tree/master/0003-Longest-Substring-Without-Repeating-Characters/java-0003/src
public class Solution1 {

    public int lengthOfLongestSubstring(String s) {

        int[] freq = new int[256];

        // sliding window: s[l...r]
        int l = 0, r = -1;
        int res = 0;

        while (l < s.length()) {

            if (r + 1 < s.length() && freq[s.charAt(r + 1)] == 0) {
                freq[s.charAt(++r)]++;
            } else    //freq[s[r+1]] == 1
            {
                freq[s.charAt(l++)]--;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println((new Solution1()).lengthOfLongestSubstring("abcabcbb"));
        System.out.println((new Solution1()).lengthOfLongestSubstring("bbbbb"));
        System.out.println((new Solution1()).lengthOfLongestSubstring("pwwkew"));
        System.out.println((new Solution1()).lengthOfLongestSubstring(""));
    }
}
