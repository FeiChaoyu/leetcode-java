package _1;

import java.util.HashMap;

/**
 * One-Pass Hash Table
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author feichaoyu
 */
public class Solution2 {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> record = new HashMap<>();
        // 在进行迭代并将元素插入到表中的同时，回过头来检查表中是否已经存在当前元素所对应的目标元素。
        // 如果它存在，那我们已经找到了对应解，并立即将其返回。
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (record.containsKey(complement)) {
                return new int[]{i, record.get(complement)};
            }

            record.put(nums[i], i);
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
        printArr((new Solution2()).twoSum(nums, target));
    }
}
