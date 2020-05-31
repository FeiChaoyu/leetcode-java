package _120;

import java.util.List;

/**
 * 一维DP
 *
 * @author feichaoyu
 */
public class Soultion2 {

    public int minimumTotal(List<List<Integer>> triangle) {

        int row = triangle.size();
        int[] minLen = new int[row + 1];

        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                minLen[j] = Math.min(minLen[j], minLen[j + 1]) + triangle.get(i).get(j);
            }
        }
        return minLen[0];
    }
}
