package practice;

public class P13ReverseList {
    /*
    No.206 reverse-linked-list
    经典的单链表反转，用一个指针肯定不够，处理当前节点时，节点的next需要指向之前的头节点
    所以next节点信息肯定要额外存起来，另外之前的头节点也要额外存，那就是3个指针
     */
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode nextHead = head.next;
            head.next = newHead;
            newHead = head;
            head = nextHead;
        }
        return newHead;
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
        ListNode res = new P13ReverseList().reverseList(a1);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
