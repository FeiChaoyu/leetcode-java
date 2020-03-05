package _83.recursion;

import _83.provider.ListNode;

/**
 * @Author feichaoyu
 * @Date 2019/12/30
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 只要当前节点和下一个节点不为空就可以
        if (head == null || head.next == null) {
            return head;
        }
        // 链表的递归问题都是分成 head + 剩余的
        // 如果当前节点值等于下一个节点值，那么当前节点就不再需要了，只需要返回后面节点，
        // 也就是 deleteDuplicates(head.next) 返回的结果

        // 否则当前节点值不等于下一个节点值，那么让head.next指向后面节点的递归结果deleteDuplicates(head.next)
        // 此时head不能舍弃

        ListNode res = deleteDuplicates(head.next);
        if (head.val == head.next.val) {
            return res;
        } else {
            head.next = res;
            return head;
        }

        // 以上可以简化为如下两行
//        head.next = deleteDuplicates(head.next);
//        return head.val == head.next.val ? head.next : head;
    }
}
