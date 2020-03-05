package _145;

import provider.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Recursive
 * Time Complexity: O(n), n is the node number in the tree
 * Space Complexity: O(h), h is the height of the tree
 *
 * @author feichaoyu
 */
public class Solution1 {

    public List<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }

    private void postorderTraversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            postorderTraversal(node.left, list);
            postorderTraversal(node.right, list);
            list.add(node.val);
        }
    }
}
