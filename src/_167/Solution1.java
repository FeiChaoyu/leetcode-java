package _167;

/**
 * Brute Force
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 *
 * @author feichaoyu
 */
public class Solution1 {

    public int[] twoSum(int[] numbers, int target) {

        if (numbers.length < 2 /*|| !isSorted(numbers)*/) {
            throw new IllegalArgumentException("Illegal argument numbers");
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    int[] res = {i + 1, j + 1};
                    return res;
                }
            }
        }

        throw new IllegalStateException("The input has no solution");
    }

    private boolean isSorted(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < numbers[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static void printArr(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        printArr((new _167.Solution1()).twoSum(nums, target));
    }
}
