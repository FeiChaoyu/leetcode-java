package _206;

import provider.ListNode;

/**
 * Iterative
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author feichaoyu
 */
public class Solution1 {

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
