package _144;

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

    public List<Integer> preorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }

    private void preorderTraversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            preorderTraversal(node.left, list);
            preorderTraversal(node.right, list);
        }
    }
}
