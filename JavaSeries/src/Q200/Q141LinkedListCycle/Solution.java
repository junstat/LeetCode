package Q200.Q141LinkedListCycle;

import DataStructure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /*
       方法一: 用set 保存结点元素，若已存在则有环，不然无环
      */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (seen.contains(head)) return true;
            seen.add(head);
            head = head.next;
        }
        return false;
    }

    /*
       方法二: 快慢针
      */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
