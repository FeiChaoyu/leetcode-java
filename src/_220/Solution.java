package _220;

import java.util.TreeSet;

/**
 * TreeSet
 * Time Complexity: O(nlogk)
 * Space Complexity: O(k)
 *
 * @author feichaoyu
 */
public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (t < 0) {
            return false;
        }

        TreeSet<Long> record = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {

            // |v-x|<=r => v-t<x<v+t => ceil(v-t)<=v+t
            // v = nums[i]
            if (record.ceiling((long) nums[i] - (long) t) != null &&
                    record.ceiling((long) nums[i] - (long) t) <= (long) nums[i] + (long) t) {
                return true;
            }

            record.add((long) nums[i]);

            // 保持record中最多有k个元素，[0,k]中有k+1个元素
            if (record.size() == k + 1) {
                record.remove((long) nums[i - k]);
            }
        }

        return false;
    }

    private static void printBool(boolean b) {
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {

        int[] nums = {-2147483648, -2147483647};
        int k = 3;
        int t = 3;
        printBool((new Solution()).containsNearbyAlmostDuplicate(nums, k, t));
    }
}
