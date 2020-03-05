package _142.哈希表;

import _142.provider.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author feichaoyu
 * @Date 2020/1/9
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return head;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return null;
    }
}
