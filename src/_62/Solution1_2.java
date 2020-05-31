package _62;

/**
 * @author feichaoyu
 */
public class Solution1_2 {

    int[][] memo;

    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        return calcTotal(m - 1, n - 1);
    }

    public int calcTotal(int i, int j) {
        if (i == 0 || j == 0) {
            return 1;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        memo[i][j] = calcTotal(i - 1, j) + calcTotal(i, j - 1);
        return memo[i][j];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1_2().uniquePaths(7, 3));
    }
}
