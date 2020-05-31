package _337;

import provider.TreeNode;

/**
 * DP
 *
 * 每个节点可选择偷或者不偷两种状态，根据题目意思，相连节点不能一起偷
 * 1.当前节点选择偷时，那么两个孩子节点就不能选择偷了
 * 2.当前节点选择不偷时，两个孩子节点只需要拿最多的钱出来就行(两个孩子节点偷不偷没关系)
 *
 * 我们使用一个大小为2的数组xxx来表示节点能够获取的钱，xxx[0]代表当前节点选择不偷时获取的钱，xxx[1]代表当前节点选择偷取时获取的钱
 * 任何一个节点能偷到的最大钱的状态可以定义为：
 * 1.当前节点选择不偷: 当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
 * 2.当前节点选择偷: 当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
 */
public class Solution2 {

    public int rob(TreeNode root) {
        int[] result = tryRob(root);
        return Math.max(result[0], result[1]);
    }

    public int[] tryRob(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] result = new int[2];

        int[] left = tryRob(root.left);
        int[] right = tryRob(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }
}
