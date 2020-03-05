package provider;

/**
 * @Author feichaoyu
 * @Date 2019/12/29
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    /**
     * 使用arr为参数，创建一个链表，当前的ListNode为链表头结点
     */
    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }

        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    public ListNode findNode(int x) {

        ListNode curNode = this;
        while (curNode != null) {
            if (curNode.val == x) {
                return curNode;
            }
            curNode = curNode.next;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            s.append(cur.val + "->");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}
