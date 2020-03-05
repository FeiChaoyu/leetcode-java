package _144;

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

    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode curNode = stack.pop();
            res.add(curNode.val);

            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }
        return res;
    }
}
