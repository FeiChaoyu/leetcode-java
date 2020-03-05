package _94;

import provider.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Classic Non-Recursive
 * Time Complexity: O(n), n is the node number in the tree
 * Space Complexity: O(h), h is the height of the tree
 *
 * @author feichaoyu
 */
public class Solution2 {

    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {

            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }
}
