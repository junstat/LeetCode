package Q0099.Q0019RemoveNthNodeFromEndOfList;

import DataStructure.ListNode;

/*
    以 n = 2
    dummy: 0 | 1 2 3 4 5   为例
           s   f
    1、删除结点必定要先找到 待删除结点的前驱；
       设待删除结点为p，其前驱为pre，通用删除操作: pre->next = p->next; 或 pre->next = pre->next->next;
    2、本例中待删除的结点为倒数第n个结点，则其前驱结点为倒数第(n+1)个结点；
    3、使用快慢指针，快指针先走n步，意图人为造一个n+1的区间 => 同步移动后，当快指针到链表尾时，慢指针在倒数第(n+1)位置；
    4、结合3、与1、，搞定收工。
  */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);   // 转换为带头结点
        ListNode first = dummy.next, second = dummy;
        // first 先走n步
        for (int i = 0; i < n; i++) first = first.next;
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
