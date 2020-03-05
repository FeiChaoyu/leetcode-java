package _209;

/**
 * Sliding Window
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author feichaoyu
 */
// 其他方法：https://github.com/liuyubobobo/Play-Leetcode/tree/master/0209-Minimum-Size-Subarray-Sum/java-0209/src
public class Solution4 {

    public int minSubArrayLen(int s, int[] nums) {

        if (s <= 0 || nums == null) {
            throw new IllegalArgumentException("Illigal Arguments");
        }

        // sliding window: nums[l...r]
        int l = 0, r = -1;
        int sum = 0;
        // res初始为一个不可能取到的最大值，后续只要有比他小的值，就会更新
        int res = nums.length + 1;

        while (l < nums.length) {

            if (r + 1 < nums.length && sum < s) {
                sum += nums[++r];
            } else {
                sum -= nums[l++];
            }

            if (sum >= s) {
                res = Math.min(res, r - l + 1);
            }
        }

        return res == nums.length + 1 ? 0 : res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println((new Solution4()).minSubArrayLen(s, nums));
    }
}
