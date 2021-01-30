package Q200.Q143ReorderList;

import DataStructure.ListNode;

import java.util.Stack;

public class Solution {
    /*
      方法一: 类似王道 Question25
          1、找中点，把链表断成前后2部分
          2、后半部分reverse
          3、同步遍历，把后半部分结点插入到前半部分
     */
    public void reorderList1(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        // step. 1
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        // step 2.
        ListNode last = mid, pre = null;
        while (last != null) {
            ListNode next = last.next;
            last.next = pre;
            pre = last;
            last = next;
        }
        // step 3.
        while (head != null && pre != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = pre.next;
            head.next.next = next;
            head = next;
        }
    }

    /*
       方法二: 空间换时间，把方法一中， step 2. 反转的活交给 Stack
      */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        Stack<ListNode> S = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            S.add(cur);
            cur = cur.next;
        }
        int cnt = (S.size() - 1) / 2;
        cur = head;
        while (cnt-- > 0) {
            ListNode t = S.pop();
            ListNode next = cur.next;
            cur.next = t;
            t.next = next;
            cur = next;
        }
        S.peek().next = null;
    }
}
