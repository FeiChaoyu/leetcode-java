package _337;

import provider.TreeNode;

import java.util.HashMap;

/**
 * 记忆化搜索
 *
 * 1.首先要明确相邻的节点不能偷，也就是爷爷选择偷，儿子就不能偷了，但是孙子可以偷
 * 2.二叉树只有左右两个孩子，一个爷爷最多2个儿子,4个孙子
 *
 * 4个孙子偷的钱+爷爷偷的钱 VS 两个儿子偷的钱，哪个组合钱多，就当做当前节点能偷的最大钱数。
 *
 * 我们发现爷爷在计算自己能偷多少钱的时候，同时计算了4个孙子能偷多少钱，也计算了2个儿子能偷多少钱。
 * 这样在儿子当爷爷时，就会产生重复计算一遍孙子节点。
 * 由于二叉树不适合拿数组当缓存，我们使用哈希表来存储结果，TreeNode当做key，能偷的钱当做value
 */
public class Solution1 {

    /**
     * TreeNode为key，能偷的钱为value
     */
    HashMap<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        return tryRob(root);
    }

    public int tryRob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        // 爷爷偷的钱
        int money = root.val;
        // 四个孙子偷的钱
        if (root.left != null) {
            money += (tryRob(root.left.left) + tryRob(root.left.right));
        }
        if (root.right != null) {
            money += (tryRob(root.right.left) + tryRob(root.right.right));
        }

        // 爷爷偷的钱+四个孙子偷的钱 VS 两个儿子偷的钱
        int result = Math.max(money, tryRob(root.left) + tryRob(root.right));
        memo.put(root, result);
        return result;
    }
}
