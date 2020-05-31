package _416;

/**
 * 二维DP
 * 状态定义：dp(i, j) 将i个元素放入容量为j的背包
 * 状态转移方程：dp(i, j) = dp(i-1, j) || dp(i-1, j-nums(i))
 * dp(i-1, j) 表示不考虑索引为i的元素，用i-1个元素已经可以填满容量为j的背包
 * dp(i-1, j-nums(i)) 表示用i-1个元素已经可以填满容量为j-nums[i]的背包
 *
 * @author feichaoyu
 */
public class Solution2 {

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                throw new IllegalArgumentException("numbers in nums must be greater than zero.");
            }
            sum += nums[i];
        }

        // sum必须是偶数才可以分成相等两部分
        if (sum % 2 != 0) {
            return false;
        }

        int n = nums.length;
        int target = sum / 2;
        boolean[][] dp = new boolean[n][target + 1];

        for (int i = 0; i <= target; i++) {
            dp[0][i] = (nums[0] == i);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                // 1.不考虑索引为i的元素，用i-1个元素已经可以填满容量为j的背包
                dp[i][j] = dp[i - 1][j];
                // 2.用i-1个元素已经可以填满容量为j-nums[i]的背包
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[n - 1][target];
    }

    private static void printBool(boolean res) {
        System.out.println(res ? "True" : "False");
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 5, 11, 5};
        printBool((new Solution2()).canPartition(nums1));

        int[] nums2 = {1, 2, 3, 5};
        printBool((new Solution2()).canPartition(nums2));
    }
}
