package _198;

import java.util.Arrays;

/**
 * Memory Search
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author feichaoyu
 */
public class Solution1 {

    /**
     * memo[i] 表示考虑抢劫 nums[i...n) 所能获得的最大收益
     */
    private int[] memo;

    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return tryRob(nums, 0);
    }

    /**
     * 考虑抢劫 nums[index...nums.size()) 这个范围内的所有房子
     *
     * @param nums
     * @param index
     * @return
     */
    private int tryRob(int[] nums, int index) {

        if (index >= nums.length) {
            return 0;
        }

        if (memo[index] != -1) {
            return memo[index];
        }

        /*
            方法一
         */
        int res = 0;
        for (int i = index; i < nums.length; i++) {
            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
        }
        memo[index] = res;
        return res;

        /*
            方法二
         */
//        return memo[index] = Math.max(tryRob(nums, index + 1),
//                nums[index] + tryRob(nums, index + 2));
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 9, 3, 1};
        System.out.println((new Solution1()).rob(nums));
    }
}
