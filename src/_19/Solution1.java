package _19;

import provider.ListNode;

/**
 * Two Pass
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author feichaoyu
 */
public class Solution1 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        int length = 0;
        // 第一次遍历计算链表长度
        for (ListNode cur = dummyHead.next; cur != null; cur = cur.next) {
            length++;
        }

        int k = length - n;
        if (k < 0) {
            throw new IllegalArgumentException("n is not valid!");
        }
        ListNode cur = dummyHead;
        // 第二次遍历找到待删除元素的位置
        for (int i = 0; i < k; i++) {
            cur = cur.next;
        }

        cur.next = cur.next.next;

        return dummyHead.next;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        System.out.println(head);

        head = (new Solution1()).removeNthFromEnd(head, 2);
        System.out.println(head);
    }
}
