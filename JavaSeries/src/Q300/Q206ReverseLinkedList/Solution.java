package Q300.Q206ReverseLinkedList;

import DataStructure.ListNode;

public class Solution {

    /*
       方法一: 遍历，逐个摘下结点，头插到新链表
      */
    public ListNode reverseList1(ListNode head) {
        ListNode p, r;  // p 为工作指针，r为p后继，防断链
        p = head;
        ListNode dummy = new ListNode(0);
        while (p != null) {
            r = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = r;
        }
        return dummy.next;
    }

    /*
       方法二: 设pre、p和r指向3个相邻的结点，假设经过若干的操作后，pre之前的结点指针都已调整完毕。
       现在令p结点的next域指向pre，注意到一旦调整指针的指向后，p的后继结点就会断链，为此需要用r
       来指向原p的后继。
       注意:
       在处理第一个结点时，应将其next域置为NULL，而不是指向头结点(因为它是结果
       链表的尾结点);
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre, p = head, r = p.next;
        p.next = null;
        while (r != null) {
            pre = p;
            p = r;
            r = r.next;
            p.next = pre;
        }
        return p;
    }
}
