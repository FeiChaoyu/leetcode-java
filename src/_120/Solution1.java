package _120;

import java.util.Arrays;
import java.util.List;

/**
 * 记忆化搜索
 *
 * @author feichaoyu
 */
public class Solution1 {

    /**
     * 行数
     */
    int row;

    /**
     * memo[i][j]表示第i行第j列元素的最小路径和
     */
    private int[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {
        row = triangle.size();
        memo = new int[row][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                memo[i][j] = -1;
            }
        }
        return calcTotal(0, 0, triangle);
    }

    private int calcTotal(int curRow, int curColumn, List<List<Integer>> triangle) {

        if (curRow == row - 1) {
            memo[curRow][curColumn] = triangle.get(curRow).get(curColumn);
            return memo[curRow][curColumn];
        }

        if (memo[curRow][curColumn] == -1) {
            int left = calcTotal(curRow + 1, curColumn, triangle);
            int right = calcTotal(curRow + 1, curColumn + 1, triangle);
            memo[curRow][curColumn] = Math.min(left, right) + triangle.get(curRow).get(curColumn);
        }

        return memo[curRow][curColumn];
    }
}
