package _213;

import java.util.Arrays;

/**
 * 记忆化搜索
 *
 * @author feichaoyu
 */
public class Solution1 {

    // 和第198题不同的地方是，这里需要用二维数组
    private int[][] memo;

    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return Math.max(tryRob(nums, 0, n - 2), tryRob(nums, 1, n - 1));
    }

    private int tryRob(int[] nums, int start, int end) {

        if (start > end) {
            return 0;
        }

        if (memo[start][end] != -1) {
            return memo[start][end];
        }

        /*
            方法一
         */
//        int res = 0;
//        for (int i = start; i <= end; i++) {
//            res = Math.max(res, nums[i] + tryRob(nums, i + 2, end));
//        }
//        memo[start][end] = res;
//        return res;

        /*
            方法二
         */
        return memo[start][end] = Math.max(tryRob(nums, start + 1, end),
                nums[start] + tryRob(nums, start + 2, end));
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 1};
        System.out.println((new _213.Solution1()).rob(nums));
    }
}


