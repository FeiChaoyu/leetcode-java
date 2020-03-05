package _141.哈希表;

import _141.provider.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author feichaoyu
 * @Date 2019/12/30
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }

        return false;
    }
}
