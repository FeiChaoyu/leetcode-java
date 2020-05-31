package _300;

import java.util.Arrays;

/**
 * Dynamic Programming
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 *
 * 定义状态：dp[i] 表示以 nums[i] 为结尾的最长上升子序列的长度
 * 状态转移：dp[i] = max{dp[i], dp[j] + 1}, 其中 0 ≤ j < i 且 num[j] < num[i]
 *
 * @author feichaoyu
 */
public class Solution2 {

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        // 每个数字都是长度为1的最长上升子序列
        Arrays.fill(dp, 1);

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {

        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println((new Solution2()).lengthOfLIS(nums1));
        // 4

        // ---

        int[] nums2 = {4, 10, 4, 3, 8, 9};
        System.out.println((new Solution2()).lengthOfLIS(nums2));
        // 3

        // ---

        int[] nums3 = {2, 2};
        System.out.println((new Solution2()).lengthOfLIS(nums3));
        // 1

        // ---

        int[] nums4 = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println((new Solution2()).lengthOfLIS(nums4));
        // 6
    }
}
