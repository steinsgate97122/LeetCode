package practice;

public class P12GetIntersectionNode {
    /*
    No.160 intersection-of-two-linked-lists
    input是两个单链表的头节点，需要返回其相交的起始节点
    问题转换为怎么让两个指针撞一起，假设相交，第一个指针到交点的距离为a，第二个指针到交点的距离为b
    共同部分的距离为c，那么第一个走到底需要a+c，第二个走到底需要b+c，走一次肯定碰不到一起
    但是a+c+b=b+c+a，所以走到底之后，只要去另一个的头开始走，就撞在一起了，而且恰好是在交点相遇
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointA = headA, pointB = headB;
        int countA = 0;
        while (true) {
            if (pointA == pointB) {
                return pointA;
            }
            if (pointA.next != null) {
                pointA = pointA.next;
            } else {
                if (countA == 1) {
                    return null;
                }
                pointA = headB;
                countA++;
            }
            if (pointB.next != null) {
                pointB = pointB.next;
            } else {
                pointB = headA;
            }
        }
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(4);
        ListNode b3 = new ListNode(5);
        ListNode c1 = new ListNode(6);
        ListNode c2 = new ListNode(7);
        ListNode c3 = new ListNode(8);
        a1.next = a2;
        b1.next = b2;
        b2.next = b3;
        a2.next = c1;
        b2.next = c1;
        c1.next = c2;
        c2.next = c3;
        ListNode res = new P12GetIntersectionNode().getIntersectionNode(a1, b1);
        System.out.println(res.val);
    }
}
