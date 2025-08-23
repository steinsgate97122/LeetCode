package practice;

public class P31ReverseBetween {
    /*
    No.92 reverse-linked-list-ii
    单链表反转的变体，只翻转left到right中间的部分，基本思路一致
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int index = 1;
        // cur指向反转头，prev指向反转头的前一个元素
        ListNode cur = head, prev = null, res;
        while (index < left) {
            prev = cur;
            cur = cur.next;
            index++;
        }
        // tmp记录right后面的第一个元素
        ListNode tmp = cur;
        for (int i = 0; i < (right - left + 1); i++) {
            tmp = tmp.next;
        }
        ListNode[] reversed = reverse(cur, right - left + 1);
        if (prev != null) {
            prev.next = reversed[0];
            res = head;
        } else {
            res = reversed[0];
        }
        reversed[1].next = tmp;
        return res;
    }

    /*
    第一个和最后一个元素都需要返回，和外面的重新拼接上
     */
    private ListNode[] reverse(ListNode head, int length) {
        if (length == 1) {
            return new ListNode[]{head, head};
        }
        ListNode prev = null, cur = head;
        for (int i = 0; i < length; i++) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return new ListNode[]{prev, head};
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        ListNode res = new P31ReverseBetween().reverseBetween(a1, 3, 5);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
