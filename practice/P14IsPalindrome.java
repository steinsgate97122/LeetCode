package practice;

public class P14IsPalindrome {
    /*
    No.234 palindrome-linked-list
    判断是否为回文链表，和回文字符串差不多的定义，不过题目要求O(1)的空间复杂度
    复杂度约束不能使用字符串或者数组来存储回文链表的信息，那么原地怎么比较呢？
    按照原结构，待比较是最后一个元素，而且是单链表，那么时间复杂度炸了，所以要改造链表结构
    先找到链表中点，然后反转后半部分，这样比较起来就方便了，中点用快慢指针就行
     */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = reverseList(slow.next);
        while (slow != null) {
            if (head.val != slow.val) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
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
        ListNode a3 = new ListNode(2);
        ListNode a4 = new ListNode(1);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        boolean res = new P14IsPalindrome().isPalindrome(a1);
        System.out.println(res);
    }
}
