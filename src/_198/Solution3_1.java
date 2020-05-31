package _198;

/**
 * DP 压缩空间
 *
 * @author feichaoyu
 */
public class Solution3_1 {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int curMax = 0, preMax = 0;
        for (int i = 0; i < n; i++) {
            int temp = curMax;
            curMax = Math.max(curMax, nums[i] + preMax);
            preMax = temp;
        }
        return curMax;
    }
}
