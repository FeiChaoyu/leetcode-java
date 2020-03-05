package _75;

/**
 * Three Way Quick Sort
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author feichaoyu
 */
public class Solution2 {

    public void sortColors(int[] nums) {

        // [0...zero] == 0
        int zero = -1;
        // [two...n-1] == 2
        int two = nums.length;
        for (int i = 0; i < two; ) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, --two);
            } else { // nums[i] == 0
                swap(nums, ++zero, i++);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void printArr(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 2, 1, 1, 0};
        (new Solution2()).sortColors(nums);
        printArr(nums);
    }
}
