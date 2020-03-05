package _283;

/**
 * 利用双指针，原地操作
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author feichaoyu
 */
public class Solution2 {

    public void moveZeroes(int[] nums) {

        // nums中，[0...k]的元素均为非0元素
        int k = 0;
        // 遍历到第i个元素后，保证[0...i]中所有非0元素都按照顺序排列在[0...k]中，同时，[k...i]为0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        // make the nums[k...end) zeros
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    private static void printArr(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 3, 12};
        (new Solution2()).moveZeroes(arr);
        printArr(arr);
    }
}
