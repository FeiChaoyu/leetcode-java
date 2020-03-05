package _79;

/**
 * Backtrack
 * Time Complexity: O(m*n*m*n)
 * Space Complexity: O(m*n)
 *
 * @author feichaoyu
 */
public class Solution {

    /**
     * 方向
     */
    private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    /**
     * 二维网格board的行和列
     */
    private int row, column;

    /**
     * 是否已经被访问过
     */
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        if (board == null || word == null) {
            throw new IllegalArgumentException("board or word can not be null!");
        }

        row = board.length;
        // 行数必须大于0
        if (row == 0) {
            return false;
        }
        column = board[0].length;
        // 默认为false
        visited = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 判断(x,y)是否在二维网格board的范围里
     *
     * @param x
     * @param y
     * @return
     */
    private boolean inArea(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < column;
    }

    /**
     * 从board[startx][starty]开始, 寻找word[index...word.size())
     *
     * @param board  给定二维网格
     * @param word   给定单词
     * @param index  单词中每个字母的索引
     * @param startX 二维网格中的横坐标
     * @param startY 二维网格中的纵坐标
     * @return 如果在给定二维网格中找到给定单词，返回true
     */
    private boolean searchWord(char[][] board, String word, int index,
                               int startX, int startY) {

        // 已经遍历到单词的末尾
        if (index == word.length() - 1) {
            return board[startX][startY] == word.charAt(index);
        }

        if (board[startX][startY] == word.charAt(index)) {
            // 标记该位置已经使用过
            visited[startX][startY] = true;
            // 遍历上下左右四个方向
            for (int i = 0; i < 4; i++) {
                int newX = startX + d[i][0];
                int newY = startY + d[i][1];
                // 在区域内，且之前没有访问过的前提下，如果searchWord返回true，则找到
                if (inArea(newX, newY) && !visited[newX][newY] &&
                        searchWord(board, word, index + 1, newX, newY)) {
                    return true;
                }
            }
            // 上下左右四个方向都没有找到，放弃该位置
            visited[startX][startY] = false;
        }
        return false;
    }

    public static void main(String[] args) {

        char[][] b1 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};

        String[] words = {"ABCCED", "SEE", "ABCB"};
        for (String word : words) {
            if ((new Solution()).exist(b1, word)) {
                System.out.println("found " + word);
            } else {
                System.out.println("can not found " + word);
            }
        }

        // ---

        char[][] b2 = {{'A'}};
        if ((new Solution()).exist(b2, "AB")) {
            System.out.println("found AB");
        } else {
            System.out.println("can not found AB");
        }
    }
}
