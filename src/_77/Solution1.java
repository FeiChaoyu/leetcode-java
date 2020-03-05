package _77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Naive Recursive
 * Time Complexity: O(n^k)
 * Space Complexity: O(k)
 *
 * @author feichaoyu
 */
public class Solution1 {

    private ArrayList<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {

        res = new ArrayList<>();
        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }

        LinkedList<Integer> c = new LinkedList<>();
        generateCombinations(n, k, 1, c);

        return res;
    }

    /**
     * 求解C(n,k)，当前已经找到的组合存储在c中，需要从start开始搜索新元素
     *
     * @param n
     * @param k
     * @param start
     * @param c
     */
    private void generateCombinations(int n, int k, int start, LinkedList<Integer> c) {

        if (c.size() == k) {
            res.add((List<Integer>) c.clone());
            return;
        }

        for (int i = start; i <= n; i++) {
            c.addLast(i);
            generateCombinations(n, k, i + 1, c);
            c.removeLast();
        }
    }

    private static void printList(List<Integer> list) {
        for (Integer e : list) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        List<List<Integer>> res = (new Solution1()).combine(4, 2);
        for (List<Integer> list : res) {
            printList(list);
        }
    }
}
