package _62;

/**
 * @author feichaoyu
 */
public class Solution1_1 {

    int[][] memo;
    int row, column;

    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        row = m;
        column = n;
        return calcTotal(0, 0);
    }

    public int calcTotal(int i, int j) {
        if (i == row - 1 || j == column - 1) {
            return 1;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        memo[i][j] = calcTotal(i + 1, j) + calcTotal(i, j + 1);
        return memo[i][j];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1_1().uniquePaths(7, 3));
    }
}
