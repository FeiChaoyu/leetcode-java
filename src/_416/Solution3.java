package _416;

/**
 * 一维DP
 *
 * @author feichaoyu
 */
public class Solution3 {

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
        boolean[] dp = new boolean[target + 1];

        for (int i = 0; i <= target; i++) {
            dp[i] = (nums[0] == i);
        }

        for (int i = 1; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[target];
    }

    private static void printBool(boolean res) {
        System.out.println(res ? "True" : "False");
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 5, 11, 5};
        printBool((new Solution3()).canPartition(nums1));

        int[] nums2 = {1, 2, 3, 5};
        printBool((new Solution3()).canPartition(nums2));
    }
}
