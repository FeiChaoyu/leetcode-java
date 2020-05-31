package _213;

/**
 * @author feichaoyu
 */
public class Solution2_1 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return nums[0];
        }
        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }

    // 仅计算闭区间 [start,end] 的最优结果
    int robRange(int[] nums, int start, int end) {
        int n = nums.length;
        int curMax = 0, preMax = 0;
        for (int i = end; i >= start; i--) {
            int temp = curMax;
            curMax = Math.max(curMax, nums[i] + preMax);
            preMax = temp;
        }
        return curMax;
    }
}
