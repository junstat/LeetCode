package Q0099.Q0023MergeKSortedLists;

import DataStructure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution3 {
    /*
   方法三: 优先队列
 */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        Comparator<ListNode> cmp = Comparator.comparingInt(a -> a.val);
        PriorityQueue<ListNode> q = new PriorityQueue<>(cmp);
        for (ListNode list : lists) if (list != null) q.add(list);
        while (!q.isEmpty()) {
            cur.next = q.poll();
            cur = cur.next;
            if (cur.next != null) q.add(cur.next);
        }
        return dummy.next;
    }
}
