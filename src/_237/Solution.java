package _237;

import provider.ListNode;

/**
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 *
 * @author feichaoyu
 */
public class Solution {

    public void deleteNode(ListNode node) {

        if (node == null || node.next == null) {
            throw new IllegalArgumentException("node should be valid and can not be the tail node.");
        }

        // 特殊问题：只能修改节点值
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};

        ListNode head = new ListNode(arr);
        System.out.println(head);

        ListNode node2 = head.findNode(2);
        (new Solution()).deleteNode(node2);
        System.out.println(head);
    }
}
