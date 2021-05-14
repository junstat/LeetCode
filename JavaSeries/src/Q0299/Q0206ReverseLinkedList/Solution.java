package Q0299.Q0206ReverseLinkedList;

import DataStructure.ListNode;

public class Solution {

    /*
       方法一: 遍历，逐个摘下结点，头插到新链表
      */
    public ListNode reverseList(ListNode head) {
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
}
