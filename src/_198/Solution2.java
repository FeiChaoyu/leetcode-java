package _198;

/**
 * Dynamic Programming
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author feichaoyu
 */
//其他方法：https://github.com/liuyubobobo/Play-Leetcode/tree/master/0198-House-Robber/java-0198/src
public class Solution2 {

    public int rob(int[] nums) {

        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        // memo[i] 表示考虑抢劫 nums[i...n) 所能获得的最大收益
        int[] memo = new int[nums.length];
        memo[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            // 1
            for (int j = i; j < n; j++) {
                // memo[i] 的取值在考虑抢劫 i 号房子和不考虑抢劫之间取最大值
                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j + 2] : 0));
            }
            // 2
//            memo[i] = Math.max(memo[i + 1],
//                    nums[i] + (i + 2 < n ? memo[i + 2] : 0));
        }

        return memo[0];
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 9, 3, 1};
        System.out.println((new Solution2()).rob(nums));
    }
}
