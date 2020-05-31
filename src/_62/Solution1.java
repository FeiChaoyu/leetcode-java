package _62;

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
     * 列数
     */
    int column;

    int[][] memo;

    public int uniquePaths(int m, int n) {
        row = m;
        column = n;
        memo = new int[m][n];
        return calcTotal(0, 0);
    }

    private int calcTotal(int curRow, int curColumn) {

        // 走到右下角
        if (curRow == row - 1 && curColumn == column - 1) {
            return 1;
        }

        if (memo[curRow][curColumn] != 0) {
            return memo[curRow][curColumn];
        }

        int below = 0;
        int right = 0;
        // 当前不是最后一行才可以继续向下走
        if (curRow != row - 1) {
            below = calcTotal(curRow + 1, curColumn);
        }
        // 当前不是最后一列才可以继续向右走
        if (curColumn != column - 1) {
            right = calcTotal(curRow, curColumn + 1);
        }
        memo[curRow][curColumn] = below + right;
        return memo[curRow][curColumn];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().uniquePaths(7, 3));
    }
}
