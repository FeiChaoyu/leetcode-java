package _46;

import java.util.ArrayList;
import java.util.List;

/**
 * Recursive get all the permutations in place
 * Time Complexity: O(n!)
 * Space Complexity: O(n)
 *
 * @author feichaoyu
 */
public class Solution2 {

    private ArrayList<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {

        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        generatePermutation(nums, 0);

        return res;
    }

    private void generatePermutation(int[] nums, int index) {

        if (index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : nums) {
                list.add(i);
            }
            res.add(list);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            generatePermutation(nums, index + 1);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private static void printList(List<Integer> list) {
        for (Integer e : list) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        List<List<Integer>> res = (new Solution1()).permute(nums);
        for (List<Integer> list : res) {
            printList(list);
        }
    }
}
