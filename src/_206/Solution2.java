package _206;

import provider.ListNode;

/**
 * Recursive
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * @author feichaoyu
 */
public class Solution2 {

    public ListNode reverseList(ListNode head) {

        // 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);

        // head->next此刻指向head后面的链表的尾节点
        // head->next->next = head把head节点放在了尾部
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
