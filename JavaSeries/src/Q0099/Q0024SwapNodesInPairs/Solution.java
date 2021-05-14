package Q0099.Q0024SwapNodesInPairs;

import DataStructure.ListNode;

public class Solution {
    /*
       1、给定两个结点: pre, p(其中，pre是p的前驱)，逆转操作: pre->next = p->next; p -> next = pre;
       2、遍历链表，工作指针为head，用以标记当前遍历位置，保证head后有2个结点则执行1、操作。
       3、注意，当逆转完成时，pre,p的相对位置关系已逆转，p为pre前驱。故，为保证不断链，
          head的后继为p,pre中的相对位置靠前的那个(逆转完成后为p) head->next = p;
          head后移处理下一对Pairs: head = pre;
    */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0, head);
        head = dummy;

        while (head != null && head.next != null && head.next.next != null) {
            ListNode pre = head.next;
            ListNode p = pre.next;

            pre.next = p.next;  // step 1.
            p.next = pre;

            head.next = p;  // step 3.
            head = pre;
        }
        return dummy.next;
    }
}
