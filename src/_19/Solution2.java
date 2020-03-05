package _19;

import provider.ListNode;

/**
 * Two Pointers - One Pass Algorithm
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * @author feichaoyu
 */
public class Solution2 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode p = dummyHead;
        ListNode q = dummyHead;
        // p、q之间距离为 n+1
        for (int i = 0; i < n + 1; i++) {
            if (q != null) {
                q = q.next;
            }
        }

        while (q != null) {
            p = p.next;
            q = q.next;
        }

        p.next = p.next.next;

        return dummyHead.next;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        System.out.println(head);

        head = (new Solution2()).removeNthFromEnd(head, 2);
        System.out.println(head);
    }
}
