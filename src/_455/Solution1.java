package _455;

import java.util.Arrays;

/**
 * Greedy Algorithm
 * Serve most greedy children first
 * Time Complexity: O(nlogn)
 * Space Complexity: O(1)
 *
 * @author feichaoyu
 */
public class Solution1 {

    public int findContentChildren(int[] g, int[] s) {

        // 从小到大排序
        Arrays.sort(g);
        Arrays.sort(s);

        // 从最大的开始
        int gi = g.length - 1, si = s.length - 1;
        int res = 0;
        while (gi >= 0 && si >= 0) {
            // 最大的饼干能够满足最贪心的孩子
            if (s[si] >= g[gi]) {
                res++;
                si--;
            }
            gi--;
        }

        return res;
    }

    public static void main(String[] args) {

        int[] g1 = {1, 2, 3};
        int[] s1 = {1, 1};
        System.out.println((new _455.Solution1()).findContentChildren(g1, s1));

        int[] g2 = {1, 2};
        int[] s2 = {1, 2, 3};
        System.out.println((new _455.Solution1()).findContentChildren(g2, s2));
    }
}
