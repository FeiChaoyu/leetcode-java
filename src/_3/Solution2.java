package _3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author feichaoyu
 */
public class Solution2 {

    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> map = new HashMap<>();
        // sliding window: s[l...r]
        int l = 0, r = -1;
        int res = 0;

        while (l < s.length()) {
            if (r + 1 < s.length() && (!map.containsKey(s.charAt(r + 1)) || map.get(s.charAt(r + 1)) == 0)) {
                map.put(s.charAt(r + 1), 1);
                r++;
            } else {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println((new Solution2()).lengthOfLongestSubstring("abcabcbb"));
        System.out.println((new Solution2()).lengthOfLongestSubstring("bbbbb"));
        System.out.println((new Solution2()).lengthOfLongestSubstring("pwwkew"));
        System.out.println((new Solution2()).lengthOfLongestSubstring(""));
    }
}
