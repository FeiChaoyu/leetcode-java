package _209;

/**
 * 滑动窗口
 *
 * @author feichaoyu
 */
public class Solution {

    public int minSubArrayLen(int s, int[] nums) {

        int sum = 0;
        // res初始为一个不可能取到的最大值，后续只要有比他小的值，就会更新
        int res = nums.length + 1;

        // sliding window: nums[left...right)
        int left = 0, right = 0;
        while (left < nums.length) {
            if (right < nums.length && sum < s) {
                sum += nums[right++];
            } else {
                sum -= nums[left++];
            }

            if (sum >= s) {
                res = Math.min(res, right - left);
            }
        }

        return res == nums.length + 1 ? 0 : res;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 7;
        System.out.println((new Solution()).minSubArrayLen(s, nums));
    }
}
