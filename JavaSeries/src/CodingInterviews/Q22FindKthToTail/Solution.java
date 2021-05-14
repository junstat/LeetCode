package CodingInterviews.Q22FindKthToTail;

/*
   面试题22: 链表中倒数第k个节点
      输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，
   从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 */


import DataStructure.ListNode;

/*
   假设整个链表有n个节点，那么倒数第k个节点就是从头节点开始的第n-k+1个节点。如果我们能够得到链表中节点的个数n，那么只要从头节点开始往后走n-k+1
   步就可以了。
 */
public class Solution {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 1) return null;

        ListNode cur = head;
        while (k-- > 1) {
            if (cur.next == null) return null;
            cur = cur.next;
        }
        ListNode behind = head;
        while (cur.next != null) {
            behind = behind.next;
            cur = cur.next;
        }
        return behind;
    }
}
