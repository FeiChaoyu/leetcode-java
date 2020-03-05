package _219;

import java.util.HashSet;

/**
 * HashSet
 * Time Complexity: O(n)
 * Space Complexity: O(k)
 *
 * @author feichaoyu
 */
public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums == null || nums.length <= 1) {
            return false;
        }

        if (k <= 0) {
            return false;
        }

        HashSet<Integer> record = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (record.contains(nums[i])) {
                return true;
            }

            record.add(nums[i]);

            // 保持record中最多有k个元素，[0,k]中有k+1个元素
            if (record.size() == k + 1) {
                record.remove(nums[i - k]);
            }
        }

        return false;
    }

    private static void printBool(boolean b) {
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1};
        int k = 1;
        printBool((new Solution()).containsNearbyDuplicate(nums, k));
    }
}
