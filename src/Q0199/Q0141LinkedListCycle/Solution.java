package Q0199.Q0141LinkedListCycle;

import DataStructure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /*
       方法一: 用set 保存结点元素，若已存在则有环，不然无环
      */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> seen = new HashSet<ListNode>();
        while (head != null) {
            if (seen.contains(head)) return true;
            seen.add(head);
            head = head.next;
        }
        return false;
    }
}
