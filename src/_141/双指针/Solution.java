package _141.双指针;

import _141.provider.ListNode;

/**
 * @Author feichaoyu
 * @Date 2019/12/30
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        // 慢指针
        ListNode slow = head;
        // 快指针
        ListNode fast = head.next;

        // 等待下一次快指针和慢指针相遇时，就说明时环形链表
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
