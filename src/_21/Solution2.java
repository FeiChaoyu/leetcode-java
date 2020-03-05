package _21;

import provider.ListNode;

/**
 * 递归法
 *
 * @Author feichaoyu
 * @Date 2019/12/29
 */
public class Solution2 {
    // 公式：
    // list1[0]+merge(list1[1:],list2)   list1[0]<list2[0]
    // list2[0]+merge(list1,list2[1:])   list2[0]<=list1[0]

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
