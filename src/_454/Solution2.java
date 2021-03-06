package _454;

import java.util.HashMap;

/**
 * HashMap
 * Time Complexity: O(n^2)
 * Space Complexity: O(n^2)
 *
 * @author feichaoyu
 */
public class Solution2 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        if (A == null || B == null || C == null || D == null) {
            throw new IllegalArgumentException("Illegal argument");
        }

        // 将A+B和C+D分别放入两个HashMap中
        HashMap<Integer, Integer> mapAB = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                if (mapAB.containsKey(sum)) {
                    mapAB.put(sum, mapAB.get(sum) + 1);
                } else {
                    mapAB.put(sum, 1);
                }
            }
        }

        HashMap<Integer, Integer> mapCD = new HashMap<>();
        for (int i = 0; i < C.length; i++)
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                if (mapCD.containsKey(sum)) {
                    mapCD.put(sum, mapCD.get(sum) + 1);
                } else {
                    mapCD.put(sum, 1);
                }
            }

        int res = 0;
        for (Integer sumab : mapAB.keySet()) {
            if (mapCD.containsKey(-sumab)) {
                res += mapAB.get(sumab) * mapCD.get(-sumab);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        int[] a = {1, 2};
        int[] b = {-2, -1};
        int[] c = {-1, 2};
        int[] d = {0, 2};
        System.out.println((new Solution2()).fourSumCount(a, b, c, d));
    }
}
