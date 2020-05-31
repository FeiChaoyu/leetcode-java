package _198;

/**
 * @author feichaoyu
 */
public class Solution2_1 {

    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int curMax = 0, preMax = 0;
        for (int i = n - 1; i >= 0; i--) {
            int temp = curMax;
            curMax = Math.max(curMax, nums[i] + preMax);
            preMax = temp;
        }
        return curMax;
    }
}
