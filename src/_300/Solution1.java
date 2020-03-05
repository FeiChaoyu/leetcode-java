package _300;

import java.util.Arrays;

/**
 * Memory Search
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 *
 * @author feichaoyu
 */
public class Solution1 {

    /**
     * memo[i] 表示以 nums[i] 为结尾的最长上升子序列的长度
     */
    private int[] memo;

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, getMaxLength(nums, i));
        }

        return res;
    }

    private int getMaxLength(int[] nums, int index) {

        if (memo[index] != -1) {
            return memo[index];
        }

        int res = 1;
        for (int i = 0; i <= index - 1; i++) {
            if (nums[index] > nums[i]) {
                res = Math.max(res, 1 + getMaxLength(nums, i));
            }
        }

        return memo[index] = res;
    }

    public static void main(String[] args) {

        int[] nums1 = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println((new Solution1()).lengthOfLIS(nums1));
        // 4

        // ---

        int[] nums2 = {4, 10, 4, 3, 8, 9};
        System.out.println((new Solution1()).lengthOfLIS(nums2));
        // 3

        // ---

        int[] nums3 = {2, 2};
        System.out.println((new Solution1()).lengthOfLIS(nums3));
        // 1

        // ---

        int[] nums4 = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println((new Solution1()).lengthOfLIS(nums4));
        // 6
    }
}
