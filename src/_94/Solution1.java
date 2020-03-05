package _94;

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

    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        return res;
    }

    private void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node != null) {
            inorderTraversal(node.left, list);
            list.add(node.val);
            inorderTraversal(node.right, list);
        }
    }
}
