package _200;

/**
 * Floodfill - DFS
 * Recursion implementation
 * Time Complexity: O(n*m)
 * Space Complexity: O(n*m)
 *
 * @author feichaoyu
 */
// 其他方法：https://github.com/liuyubobobo/Play-Leetcode/tree/master/0200-Number-of-Islands/java-0200/src
public class Solution1 {

    /**
     * 方向
     */
    private int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * 二维数组的行和列
     */
    private int row, column;

    /**
     * 是否已经被访问过
     */
    private boolean[][] visited;

    public int numIslands(char[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        row = grid.length;
        column = grid[0].length;

        visited = new boolean[row][column];

        int res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }

        return res;
    }

    private void dfs(char[][] grid, int x, int y) {
        // 不需要显示递归终止条件
        // 只需要循环四个方向即可退出

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newx = x + d[i][0];
            int newy = y + d[i][1];
            // 在区域内，且之前没有访问过的前提下，如果当前是陆地'1'，则继续找
            if (inArea(newx, newy) && !visited[newx][newy] && grid[newx][newy] == '1') {
                dfs(grid, newx, newy);
            }
        }
        // 注意这里visited[x][y]不需要置位fasle
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < column;
    }

    public static void main(String[] args) {

        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println((new Solution1()).numIslands(grid1));
        // 1

        // ---

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println((new Solution1()).numIslands(grid2));
        // 3
    }
}
