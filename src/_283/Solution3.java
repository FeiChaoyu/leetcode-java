package _283;

/**
 * @author feichaoyu
 */
public class Solution3 {

    public void moveZeroes(int[] nums) {

        // nums中，[0...k]的元素均为非0元素
        int k = 0;
        // 遍历到第i个元素后，保证[0...i]中所有非0元素都按照顺序排列在[0...k]中，同时，[k...i]为0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // if-else 优化了一种情况：如果所有元素都不为0，可以避免自己和自己交换
                if (k != i) {
                    // 相比Solution2，每次不仅赋值，还需要把后面的0也填上
                    // 交换操作可以省略后面一次for循环
                    swap(nums, k++, i);
                } else {
                    k++;
                }

            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    private static void printArr(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 3, 12};
        (new Solution3()).moveZeroes(arr);
        printArr(arr);
    }
}
