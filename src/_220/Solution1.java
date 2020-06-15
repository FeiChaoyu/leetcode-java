package _220;

import java.util.Map;
import java.util.TreeSet;

/**
 * TreeSet
 * Time Complexity: O(nlogk)
 * Space Complexity: O(k)
 *
 * @author feichaoyu
 */
public class Solution1 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (t < 0) {
            return false;
        }

        Map<>
        for (int i = 0; i < nums.length; i++) {

            if (record.contains((long) nums[i] - (long) t)) {
                return true;
            }

            if (record.contains((long) t - (long) nums[i])) {
                return true;
            }


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

        int[] nums = {2, 1};
        int k = 1;
        int t = 1;
        printBool((new Solution1()).containsNearbyAlmostDuplicate(nums, k, t));
    }
}
