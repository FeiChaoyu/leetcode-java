package _283;

import java.util.ArrayList;

/**
 * 利用额外空间，不满足条件
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author feichaoyu
 */
public class Solution1 {

    public void moveZeroes(int[] nums) {

        ArrayList<Integer> nonZeroElements = new ArrayList<Integer>();

        // put all the non zero elements into a new vector
        for (int num : nums) {
            if (num != 0) {
                nonZeroElements.add(num);
            }
        }

        // make nums[0...nonZeroElements.size()) all non zero elements
        for (int i = 0; i < nonZeroElements.size(); i++) {
            nums[i] = nonZeroElements.get(i);
        }

        // make nums[nonZeroElements.size()...nums.size()) all zero elements
        for (int i = nonZeroElements.size(); i < nums.length; i++) {
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
        (new Solution1()).moveZeroes(arr);
        printArr(arr);
    }
}
