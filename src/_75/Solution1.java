package _75;

/**
 * Counting Sort
 * Time Complexity: O(n)
 * Space Complexity: O(3)
 *
 * @author feichaoyu
 */
public class Solution1 {

    public void sortColors(int[] nums) {

        int[] count = {0, 0, 0};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0 && nums[i] <= 2) {
                count[nums[i]]++;
            }
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[index++] = i;
            }
        }

//        for (int i = 0; i < count[0]; i++) {
//            nums[index++] = 0;
//        }
//        for (int i = 0; i < count[1]; i++) {
//            nums[index++] = 1;
//        }
//        for (int i = 0; i < count[2]; i++) {
//            nums[index++] = 2;
//        }
    }

    public static void printArr(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 2, 1, 1, 0};
        (new Solution1()).sortColors(nums);
        printArr(nums);
    }
}
