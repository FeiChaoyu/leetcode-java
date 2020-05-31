package _416;

import java.util.Arrays;

/**
 * 记忆化搜索
 *
 * @author feichaoyu
 */
public class Solution1 {

    /**
     * memo[i][c] 表示使用索引为[0...i]的这些元素，是否可以完全填充一个容量为c的背包
     * -1 表示未计算，0 表示不可以填充，1 表示可以填充
     */
    private int[][] memo;

    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int num : nums) {
            if (num <= 0) {
                throw new IllegalArgumentException("numbers in nums must be greater than zero.");
            }
            sum += num;
        }

        // sum必须是偶数才可以分成相等两部分
        if (sum % 2 != 0) {
            return false;
        }

        memo = new int[nums.length][sum / 2 + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        // 背包大小为sum/2
        return tryPartition(nums, nums.length - 1, sum / 2);
    }

    private boolean tryPartition(int[] nums, int index, int sum) {

        // 背包空间为0，已经填充完
        if (sum == 0) {
            return true;
        }

        if (sum < 0 || index < 0) {
            return false;
        }

        if (memo[index][sum] != -1) {
            return memo[index][sum] == 1;
        }

        // 1.不考虑索引为index的数字，用index-1个数字已经可以填满sum容量的背包
        // 2.用index-1个数字已经可以填满sum-nums[index]容量的背包
        // 有一种方式成功，就返回true
        memo[index][sum] = (tryPartition(nums, index - 1, sum) ||
                tryPartition(nums, index - 1, sum - nums[index])) ? 1 : 0;

        return memo[index][sum] == 1;
    }

    private static void printBool(boolean res) {
        System.out.println(res ? "True" : "False");
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 5, 11, 5};
        printBool((new Solution1()).canPartition(nums1));

        int[] nums2 = {1, 2, 3, 5};
        printBool((new Solution1()).canPartition(nums2));
    }
}
