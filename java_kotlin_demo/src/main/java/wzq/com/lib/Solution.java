package wzq.com.lib;

/**
 * <p>作者：wzq<p>
 * <p>创建时间：2020/10/30<p>
 * <p>文件描述：<p>
 */
public class Solution {

    public  ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p3 = null;

        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        head.next = null;
        head = p1;
        return head;
    }
}
