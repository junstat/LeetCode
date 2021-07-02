package Q0199.Q0141LinkedListCycle;

import DataStructure.ListNode;

public class Solution2 {
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
