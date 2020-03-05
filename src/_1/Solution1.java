package _1;

import java.util.HashMap;

/**
 * Two-Pass Hash Table
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author feichaoyu
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> record = new HashMap<>();
        // 在第一次迭代中，我们将每个元素的值和它的索引添加到表中
        for (int i = 0; i < nums.length; i++) {
            record.put(nums[i], i);
        }

        // 在第二次迭代中，我们将检查每个元素所对应的目标元素(target - nums[i])是否存在于表中
        for (int i = 0; i < nums.length; i++) {
            Integer index = record.get(target - nums[i]);
            if (index != null && index != i) {
                return new int[]{i, index};
            }
        }

        throw new IllegalStateException("the input has no solution");
    }

    private static void printArr(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {0, 4, 3, 0};
        int target = 0;
        printArr((new Solution1()).twoSum(nums, target));
    }
}
